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
public class RoleDTO {
    private String roleId;
    private String userName;
    private String password;
    private String type;//"",CUSTOMER,DRIVER
}
