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
    @Column(name = "nicNo", unique = true, nullable = false)
    private String nicNo;
    private String address;
    private String contactNo;
    private String email;
    private String nicImg;
    private String licenceNo;
    private String licenceImg;
    private String username;
    private String password;
    private Boolean isRegistered=false;
    private Boolean isDriverRequested=false;
    private String isAccept;//PENDING,ACCEPTED,DENIED
    private String type;//CUSTOMER

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CarRentDetails> rentals = new ArrayList<>();

}