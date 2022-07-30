package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;

import java.util.List;

public interface CarService {
    void saveCar(CarDTO dto);

    void updateCar(CarDTO dto);

    void deleteCar(String registrationNO);

    List<CarDTO> getAllCars();

    CarDTO searchCar(String registrationNO);

//    void updateCar(String registrationNO);

    void updateCarFilePaths(String frontImg, String backImg, String interImg, String sideImg, long id);


    List<CarDTO> getAllCarsByStatus(String status);

    int getCountOfCarsByStatus(String status);
}
