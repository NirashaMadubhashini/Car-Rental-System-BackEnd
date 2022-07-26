package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Customer {
    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
    private String customerId;
    private String name;
    private String address;
    private int contactNo;
    private String email;
    private String nicNo;
    private String nicImg;
    private String licenceNo;
    private String licenceImg;
    private String username;
    private String password;
    private Boolean isRegistered=false;
    private Boolean isDriverRequested=false;
    private Boolean isAccept;//PENDING,ACCEPTED,DENIED

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CarRentDetails> rentals = new ArrayList<>();

}