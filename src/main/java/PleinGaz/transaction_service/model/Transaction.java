package PleinGaz.transaction_service.model;
import PleinGaz.transaction_service.enums.TransactionType;
import PleinGaz.transaction_service.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;// import des dates métiers
import lombok.Data;// pour éviter les répétitions de code

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;
    private String clientId;
    private String contratId;
    private Double montant;
    private String telephoneMomo;
    private TransactionType type;
    private TransactionStatus statut;
    private LocalDateTime dateInitiation;
    private LocalDateTime dateCompletion;
    private String referenceEcw;
    private String messageErreur;

}