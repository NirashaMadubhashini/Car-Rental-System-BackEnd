package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
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
    private double dailyRate;
    private double monthlyRate;
    private double freeKmForPrice;
    private double freeKmForDuration;
    private double lossDamageWaiver;
    private double priceForExtraKm;
    private double completeKm;
    private Boolean isAvailable = false;
}