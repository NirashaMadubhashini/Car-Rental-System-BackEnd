package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO dto);

    void updateDriver(DriverDTO dto);

    void deleteDriver(String did);

    DriverDTO searchDriver(String did);

    List<DriverDTO> getAllDrivers();

    List<DriverDTO> getAllAvailableDrivers();

    List<DriverDTO> getAllNonAvailableDrivers();

    int getCountOfDriversByStatus(boolean availability);
}
