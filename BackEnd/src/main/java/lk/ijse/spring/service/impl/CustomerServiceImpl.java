package lk.ijse.spring.service.impl;


import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (!repo.existsByNicNo(dto.getNicNo())) {
            dto.setIsAccept("PENDING");
            dto.setType("CUSTOMER");
            repo.save(mapper.map(dto, Customer.class));
        } else {
            throw new RuntimeException("Customer Already Exists");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (repo.existsByNicNo(dto.getNicNo())) {
            repo.save(mapper.map(dto, Customer.class));
        } else {
            throw new RuntimeException("No Such Customer To Update");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String nicNo) {
        if (repo.existsById(nicNo)) {
            return mapper.map(repo.findById(nicNo).get(), CustomerDTO.class);
        } else {
            throw new RuntimeException("No Such Customer");
        }
    }

    @Override
    public void deleteCustomer(String nicNo) {
        if (repo.existsByNicNo(nicNo)) {
            repo.deleteByCustomerId(nicNo);
        } else {
            throw new RuntimeException("No Such Customer To Delete");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapper.map(repo.findAll(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public List<CustomerDTO> getAllPendingCustomers() {
        return mapper.map(repo.findPendingCustomers(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public List<CustomerDTO> getAllAcceptedCustomers() {
        return mapper.map(repo.findAcceptedCustomers(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public void uploadCustomerImages(String nicfPath, String nicbPath, String licenceImgPath, String id) {
        if (repo.existsById(id)) {
            repo.updateCustomerFilePaths(nicfPath, nicbPath, licenceImgPath, id);
        } else {
            throw new RuntimeException("Customer Not Found");
        }
    }

    @Override
    public int getCountOfCustomersRegistered() {
        return repo.countByCustomerId();
    }
}