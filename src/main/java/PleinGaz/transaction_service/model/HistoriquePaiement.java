package PleinGaz.transaction_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import PleinGaz.transaction_service.enums.TransactionStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "paiements")
public class HistoriquePaiement {

    @Id
    private String id;

    private String transactionId;
    private String clientId;
    private Double montant;
    private TransactionStatus statut;
}