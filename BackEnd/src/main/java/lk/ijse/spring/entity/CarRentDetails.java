package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class CarRentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String rentId;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date pickUpDate;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date pickUpTime;


    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date returnDate;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date returnTime;

    private String slipFile;

    private String carType;//GENERAL,PREMIUM,LUXURY

    private Boolean isDriver = false;

    @ManyToOne
    @JoinColumn(name = "nicNo", referencedColumnName = "nicNo", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "registrationNO", referencedColumnName = "registrationNO", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "did", referencedColumnName = "did", nullable = false)
    private Driver driver;
}
