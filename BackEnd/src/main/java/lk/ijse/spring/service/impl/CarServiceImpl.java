package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        if (!repo.existsById(dto.getId())) {
            repo.save(mapper.map(dto, Car.class));
        } else {
            throw new RuntimeException("Car Already Exists");
        }
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (repo.existsById(dto.getId())) {
            repo.save(mapper.map(dto, Car.class));
        } else {
            throw new RuntimeException("No Such Car To Update");
        }
    }

    @Override
    public void deleteCar(long registrationNO) {
        if (repo.existsById(registrationNO)) {
            repo.deleteById(registrationNO);
        } else {
            throw new RuntimeException("No Such Car To Delete");
        }
    }

    @Override
    public List<CarDTO> getAllCars() {
        return mapper.map(repo.findAll(), new TypeToken<List<CarDTO>>() {
        }.getType());
    }

    @Override
    public CarDTO searchCar(long id) {
        return mapper.map(repo.findById(id).get(), CarDTO.class);
    }

    @Override
    public void updateCarStatus(long id, String status) {
        if (repo.existsById(id)) {
            repo.updateCarStatus(status,id);
        } else {
            throw new RuntimeException("No Such Car To Update");
        }
    }

    @Override
    public void updateCarFilePaths(String frontImg, String backImg, String interImg, String sideImg,long id) {
        if (repo.existsById(id)) {
            repo.updateCarFilePaths(frontImg, backImg, interImg, sideImg, id);
        } else {
            throw new RuntimeException("No Such Car To Update");
        }
    }

    @Override
    public List<CarDTO> getAllCarsByStatus(String status) {
        return mapper.map(repo.getAllCarsByStatus(status), new TypeToken<List<CarDTO>>() {
        }.getType());
    }

    @Override
    public int getCountOfCarsByStatus(String status) {
        return repo.getCountOfCarsByStatus(status);
    }
}
