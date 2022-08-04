package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService service;

    @Autowired
    CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAdmins() {
        return new ResponseUtil(200, "Ok", service.getAllAdmins());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(AdminDTO dto) {
        if (!(dto.getAdminId().equals(""))){
            service.saveAdmin(dto);
            return new ResponseUtil(200, "Saved", null);
        }else {
            return new ResponseUtil(404, "NotSaved", null);
        }
    }
    @PostMapping(path = "req/accept/{type}/{nicNo}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil acceptCustomer(@PathVariable String type,@PathVariable String nicNo) {
        if (!(nicNo.equals(""))){
            customerService.changeCustomerStatus(type,nicNo);
            return new ResponseUtil(200, "Saved", null);
        }else {
            return new ResponseUtil(404, "NotSaved", null);
        }
    }

}
