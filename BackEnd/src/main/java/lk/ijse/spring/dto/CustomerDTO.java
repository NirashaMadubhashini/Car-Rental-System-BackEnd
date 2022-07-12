package lk.ijse.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
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
    private Boolean isAccept;
}