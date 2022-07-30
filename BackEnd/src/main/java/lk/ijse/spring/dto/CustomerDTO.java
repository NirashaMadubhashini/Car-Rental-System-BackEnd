package lk.ijse.spring.dto;


import lk.ijse.spring.entity.CarRentDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String nicNo;
    private String address;
    private int contactNo;
    private String email;
    private String nicImg;
    private String licenceNo;
    private String licenceImg;
    private String username;
    private String password;
    private Boolean isRegistered=false;
    private Boolean isDriverRequested=false;
    private String isAccept;
    private String type;//CUSTOMER

    private List<CarRentDetailDTO> rentals = new ArrayList<>();

}