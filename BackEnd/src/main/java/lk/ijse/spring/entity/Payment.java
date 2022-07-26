package lk.ijse.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String paymentId;
    private String paymentType;//CARD,CASH
    private Double fullPayment;
    private Boolean isPay = false;
    private Double lossDamageWaiver;
    private Double rentalFee;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;


}
