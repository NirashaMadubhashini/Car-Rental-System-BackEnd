package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepo repo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void saveDriver(DriverDTO dto) {
        if (!repo.existsByDid(dto.getDid())) {
            repo.save(mapper.map(dto,Driver.class));
        } else {
            throw new RuntimeException("Driver Already Exists");
        }
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (repo.existsByDid(dto.getDid())) {
            repo.save(mapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("No Such Driver To Update");
        }
    }

    @Override
    public void deleteDriver(String did ) {
        if (repo.existsByDid(did)) {
            repo.deleteByLicenseNo(did );
        } else {
            throw new RuntimeException("No Such Driver To Delete");
        }
    }

    @Override
    public DriverDTO searchDriver(String did) {
        if (repo.existsByDid(did )) {
            return mapper.map(repo.findById(did).get(), DriverDTO.class);
        } else {
            throw new RuntimeException("Driver Not Found...");
        }
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        return mapper.map(repo.findAll(), new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

    @Override
    public List<DriverDTO> getAllAvailableDrivers() {
        return mapper.map(repo.getAllAvailableDrivers(), new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

    @Override
    public List<DriverDTO> getAllNonAvailableDrivers() {
        return mapper.map(repo.getAllNonAvailableDrivers(), new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

    @Override
    public int getCountOfDriversByStatus(boolean availability) {
        return repo.getCountOfDriversByStatus(availability);
    }
}