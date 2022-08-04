package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, String> {

    boolean existsByAdminId(String adminId);

    Optional<Admin> findAdminByUsername(String username);

    Optional<Admin> findAdminByPassword(String password);

    boolean existsByUsernameAndPassword(String username,String password);

}
