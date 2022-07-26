package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarRepo  extends JpaRepository<Car, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Car SET status=:status WHERE id=:id", nativeQuery = true)
    void updateCarStatus(@Param("status") String status, @Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Car SET frontViewImg=:frontViewImg,backViewImg=:backViewImg,internalViewImg=:internalViewImg,sideViewImg=:sideViewImg WHERE id=:id", nativeQuery = true)
    void updateCarFilePaths(@Param("frontViewImg") String frontViewImg, @Param("backViewImg") String backViewImg, @Param("internalViewImg") String internalViewImg, @Param("sideViewImg") String sideViewImg, @Param("id")  long id);

    @Query(value = "SELECT * FROM Car WHERE status=:status", nativeQuery = true)
    List<Car> getAllCarsByStatus(@Param("status") String status);

    @Query(value = "SELECT COUNT(id) FROM Car WHERE status=:status", nativeQuery = true)
    int getCountOfCarsByStatus(@Param("status") String status);
}