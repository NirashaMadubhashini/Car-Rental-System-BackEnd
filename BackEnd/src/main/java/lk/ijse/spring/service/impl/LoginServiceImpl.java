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

        ResponseUtilLogin responseUtilLogin = new ResponseUtilLogin();
        if (adminRepo.existsByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword())) {
            responseUtilLogin.setCode(200);
            responseUtilLogin.setMessage("Login Successful");
            responseUtilLogin.setType("Admin");
        } else if (driverRepo.existsByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword())) {
            responseUtilLogin.setCode(200);
            responseUtilLogin.setMessage("Login Successful");
            responseUtilLogin.setType("Driver");

        } else if (customerRepo.existsByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword())) {

            Customer cus = customerRepo.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
            if (cus.getIsAccept().equals("ACCEPTED")) {
                responseUtilLogin.setCode(200);
                responseUtilLogin.setMessage("Login Successful");
                responseUtilLogin.setType("Customer");
            } else if (cus.getIsAccept().equals("DENIED")) {
                responseUtilLogin.setCode(403);
                responseUtilLogin.setMessage("Login Request Was Denied By Admin");
                responseUtilLogin.setType("Customer");
            } else if (cus.getIsAccept().equals("PENDING")) {
                responseUtilLogin.setCode(405);
                responseUtilLogin.setMessage("Your Request Still Pending");
                responseUtilLogin.setType("Customer");
            } else {
                responseUtilLogin.setCode(406);
                responseUtilLogin.setMessage("Your Login Successful");
                responseUtilLogin.setType("Customer");
            }

        } else{
            responseUtilLogin.setCode(407);
            responseUtilLogin.setMessage("Please Re-Check your Credentials");
            responseUtilLogin.setType("null");
        }

            return responseUtilLogin;
    }
}
