package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepo extends JpaRepository<Maintenance, String> {
}
