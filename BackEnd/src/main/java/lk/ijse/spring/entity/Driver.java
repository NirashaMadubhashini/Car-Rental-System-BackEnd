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
public class Driver {
    @Id
    @Column(name = "did", unique = true, nullable = false)
    private String did;
    private String name;
    private String address;
    private String contactNo;
    private String nicNo;
    private String licenseNo;
    private String username;
    private String password;
    private final boolean isAvailable=false;

    @OneToOne(cascade = CascadeType.ALL)
    private Car car;

    @OneToOne(cascade = CascadeType.ALL)
    private DriverSchedule schedule;
}
