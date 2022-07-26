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
public class DriverSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String scheduleId;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date time;



    @OneToOne(cascade = CascadeType.ALL)
    private Car car;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
}
