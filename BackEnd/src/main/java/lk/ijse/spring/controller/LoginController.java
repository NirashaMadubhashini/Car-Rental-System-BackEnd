package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.LoginDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.LoginService;
import lk.ijse.spring.util.ResponseUtil;
import lk.ijse.spring.util.ResponseUtilLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtilLogin Login(@RequestBody LoginDTO dto) {
        String msg = "";
        if (!(dto.getUsername().equals("") && dto.getPassword().equals(""))){
             return service.signIn(dto);
        }else {
            return new ResponseUtilLogin(404, msg, "null");
        }

    }
}
