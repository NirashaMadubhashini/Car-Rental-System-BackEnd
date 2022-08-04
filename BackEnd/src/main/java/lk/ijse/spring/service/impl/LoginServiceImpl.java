package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.LoginDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.LoginService;
import lk.ijse.spring.util.ResponseUtil;
import lk.ijse.spring.util.ResponseUtilLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    CustomerRepo customerRepo;


    @Override
    public ResponseUtilLogin signIn(LoginDTO loginDTO) {

        ResponseUtilLogin responseUtilLogin = null;
        if(adminRepo.existsByUsernameAndPassword(loginDTO.getUsername(),loginDTO.getPassword())) {
            responseUtilLogin.setCode(200);
            responseUtilLogin.setMessage("Login Success Ful");
            responseUtilLogin.setType("Admin");
        }

        if(driverRepo.existsByUsernameAndPassword(loginDTO.getUsername(),loginDTO.getPassword())){
            responseUtilLogin.setCode(200);
            responseUtilLogin.setMessage("Login Success Ful");
            responseUtilLogin.setType("Driver");

        }

        if(customerRepo.existsByUsernameAndPassword(loginDTO.getUsername(),loginDTO.getPassword())){
            Customer cus = customerRepo.findDistinctByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
            responseUtilLogin.setCode(200);
            responseUtilLogin.setMessage("Login Success Ful");
            responseUtilLogin.setType("Customer");

        }

        return responseUtilLogin;

    }
}
