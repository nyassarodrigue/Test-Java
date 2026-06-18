package PleinGaz.transaction_service.repository;

import PleinGaz.transaction_service.enums.TransactionStatus;
import PleinGaz.transaction_service.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository
        extends MongoRepository<Transaction, String> {
    List<Transaction> findByClientId(String clientId);

    Optional<Transaction> findByReferenceEcw(String referenceEcw);

    List<Transaction> findByStatut(TransactionStatus statut);

}