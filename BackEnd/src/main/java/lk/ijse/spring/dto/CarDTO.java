package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
    private long idCar;
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
}