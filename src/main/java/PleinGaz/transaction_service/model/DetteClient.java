package PleinGaz.transaction_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "dettes")
public class DetteClient {

    @Id
    private String id;
    private String clientId;
    private String contratId;
    private Double montantTotal;
    private Double montantRembourse;
    private Double montantRestant;
    private Integer nombreEcheancesTotal;
    private Integer nombreEcheancesPayees;
    private Integer nombreEcheancesRestantes;
    private LocalDateTime dernierPaiement;
    private String statut;
}