package PleinGaz.transaction_service.repository;

import PleinGaz.transaction_service.model.HistoriquePaiement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoriquePaiementRepository
        extends MongoRepository<HistoriquePaiement, String> {

}