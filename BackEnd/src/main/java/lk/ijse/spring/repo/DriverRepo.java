package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface DriverRepo extends JpaRepository<Driver, String> {

    boolean existsByDid(String  did);


    @Modifying
    @Transactional
    @Query("delete from Driver d where d.did= ?1")
    void deleteByLicenseNo(String firstName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Driver WHERE did =:did ", nativeQuery = true)
    void updateDriver(@Param("did") String did);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Driver SET availability = true WHERE did=:did ", nativeQuery = true)
    void updateDriverAvailable(@Param("did") String licenseNo );

    @Query(value = "SELECT * FROM Driver WHERE availability=true", nativeQuery = true)
    List<Driver> getAllAvailableDrivers();

    @Query(value = "SELECT * FROM Driver WHERE availability=false", nativeQuery = true)
    List<Driver> getAllNonAvailableDrivers();

    @Query(value = "SELECT COUNT(did) FROM Driver WHERE availability=:availability", nativeQuery = true)
    int getCountOfDriversByStatus(@Param("availability") boolean availability);
}