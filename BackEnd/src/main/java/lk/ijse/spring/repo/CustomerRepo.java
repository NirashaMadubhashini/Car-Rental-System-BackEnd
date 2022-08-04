package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    boolean existsByNicNo(String NicNo);

    @Modifying
    @Transactional
    @Query("delete from Customer c where c.nicNo = ?1")
    void deleteByCustomerId(String firstName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Customer  WHERE nicNo=:nicNo", nativeQuery = true)
    void updateCustomer(@Param("nicNo") String nicNo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Customer SET isAccept=:type WHERE nicNo=:nicNo", nativeQuery = true)
    void updateCustomerStatus(@Param("type") String type,@Param("nicNo") String nicNo);

    @Query(value = "SELECT * FROM Customer WHERE isAccept='PENDING'", nativeQuery = true)
    List<Customer> findPendingCustomers();

    @Query(value = "SELECT * FROM Customer WHERE status='Accepted'", nativeQuery = true)
    List<Customer> findAcceptedCustomers();

    @Modifying
    @Transactional
    @Query(value = "UPDATE Customer SET nicFrontImg=:nicFrontImg,nicBackImg=:nicBackImg,licenceImg=:licenceImg WHERE nicNo=:nicNo", nativeQuery = true)
    void updateCustomerFilePaths(@Param("nicFrontImg") String nicFrontImg, @Param("nicBackImg") String nicBackImg, @Param("licenceImg") String licenceImg, @Param("nicNo") String nicNo);

    @Query(value = "SELECT COUNT(nicNo) FROM Customer WHERE status='Accepted'",nativeQuery = true)
    int countByCustomerId();
}
