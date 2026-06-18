package PleinGaz.transaction_service.service;

import PleinGaz.transaction_service.enums.TransactionStatus;
import PleinGaz.transaction_service.repository.TransactionRepository;
import PleinGaz.transaction_service.repository.DetteClientRepository;
import PleinGaz.transaction_service.repository.HistoriquePaiementRepository;
import PleinGaz.transaction_service.model.Transaction;
import org.springframework.stereotype.Service;
import PleinGaz.transaction_service.model.HistoriquePaiement;
import java.time.LocalDateTime;
import PleinGaz.transaction_service.model.DetteClient;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final DetteClientRepository detteClientRepository;
    private final HistoriquePaiementRepository historiquePaiementRepository;

    public TransactionServiceImpl(
            TransactionRepository transactionRepository,
            DetteClientRepository detteClientRepository,
            HistoriquePaiementRepository historiquePaiementRepository) {

        this.transactionRepository = transactionRepository;
        this.detteClientRepository = detteClientRepository;
        this.historiquePaiementRepository = historiquePaiementRepository;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {

        transaction.setStatut(TransactionStatus.PENDING);

        transaction.setDateInitiation(LocalDateTime.now());

        transaction.setReferenceEcw(generateReference());

        // Sauvegarde transaction
        Transaction savedTransaction =
                transactionRepository.save(transaction);

        // Création historique paiement
        HistoriquePaiement historique =
                new HistoriquePaiement();

        historique.setTransactionId(savedTransaction.getId());

        historique.setClientId(savedTransaction.getClientId());

        historique.setMontant(savedTransaction.getMontant());

        historique.setStatut(savedTransaction.getStatut());

        historiquePaiementRepository.save(historique);
        // Recherche de la dette du client
        DetteClient dette =
                detteClientRepository
                        .findByClientId(savedTransaction.getClientId())
                        .orElseThrow();


// Vérification dette soldée
        if (dette.getMontantRestant() <= 0) {
            throw new RuntimeException("Dette déjà remboursée");
        }


// Vérification surpaiement
        if (savedTransaction.getMontant() > dette.getMontantRestant()) {
            throw new RuntimeException("Montant supérieur à la dette restante");
        }


// Mise à jour montant remboursé
        dette.setMontantRembourse(
                dette.getMontantRembourse()
                        + savedTransaction.getMontant()
        );


// Calcul reste à payer
        dette.setMontantRestant(
                dette.getMontantTotal()
                        - dette.getMontantRembourse()
        );


// Mise à jour date dernier paiement
        dette.setDernierPaiement(LocalDateTime.now());


// Sauvegarde dette
        detteClientRepository.save(dette);
        return savedTransaction;
    }

    private String generateReference() {
        return "ECW-" + System.currentTimeMillis();
    }
}