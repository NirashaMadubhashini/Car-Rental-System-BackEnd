package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcar", unique = true, nullable = false)
    private Long idCar;
    private String registrationNO;
    private String brand;
    private String type;
    private int noOfPassengers;
    private String transmissionType;
    private String fuelType;
    private String color;
    private String frontViewImg;
    private String backViewImg;
    private String sideViewImg;
    private String internalViewImg;
    private BigDecimal dailyRate;
    private BigDecimal monthlyRate;
    private BigDecimal freeKmForPrice;
    private BigDecimal freeKmForDuration;
    private BigDecimal lossDamageWaiver;
    private BigDecimal priceForExtraKm;
    private BigDecimal completeKm;
    private Boolean isAvailable = false;


    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;
}