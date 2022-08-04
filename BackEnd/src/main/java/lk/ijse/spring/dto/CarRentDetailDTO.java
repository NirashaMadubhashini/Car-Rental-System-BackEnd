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
public class CarRentDetailDTO {
    private String rentId;
    private LocalDate date;
    private LocalDate pickUpDate;
    private LocalDate pickUpTime;
    private LocalDate returnDate;
    private LocalDate returnTime;
    private String location;
    private String slipFile;
    private String carType;
    private String status;
    private CustomerDTO customer;
    private CarDTO car;
    private DriverDTO driver;
}
