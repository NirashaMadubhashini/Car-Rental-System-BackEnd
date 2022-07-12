package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PaymentDTO {
    private String paymentId;
    private String paymentType;//CARD,CASH
    private Double fullPayment;
    private Boolean isPay=false;
    private Double lossDamageWaiver;
    private Double rentalFee;
}
