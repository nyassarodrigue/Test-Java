package PleinGaz.transaction_service.repository;

import PleinGaz.transaction_service.model.DetteClient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DetteClientRepository
        extends MongoRepository<DetteClient, String> {

    Optional<DetteClient> findByClientId(String clientId);

}