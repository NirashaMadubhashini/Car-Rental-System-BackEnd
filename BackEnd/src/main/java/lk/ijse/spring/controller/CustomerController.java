package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO dto) {
        if (!(dto.getNicNo().equals(""))){
            service.saveCustomer(dto);
            return new ResponseUtil(200, "Saved", null);
        }else {
            return new ResponseUtil(404, "NotSaved", null);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil(200, "Ok", service.getAllCustomers());
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        if (!(dto.getNicNo().equals(""))){
            service.updateCustomer(dto);
            return new ResponseUtil(200, "Updated", null);
        }else {
            return new ResponseUtil(404, "NotUpdated", null);
        }
    }

    @DeleteMapping(params = {"nicNo"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String nicNo) {
        if (!(nicNo.equals(""))){
            service.deleteCustomer(nicNo);
            return new ResponseUtil(200, "Deleted", null);
        }else {
            return new ResponseUtil(404, "NotDeleted", null);
        }
    }

    @GetMapping(params = {"nicNo"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String nicNo) {
        return new ResponseUtil(200, "Ok", service.searchCustomer(nicNo));
    }

    @GetMapping(path = "/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomerByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
            return new ResponseUtil(404, "Incorrect Username", null);

    }

    @GetMapping(path = "/pending", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPendingCustomers() {
        return new ResponseUtil(200, "Ok", service.getAllPendingCustomers());
    }

    @GetMapping(path = "/accepted", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAcceptedCustomers() {
        return new ResponseUtil(200, "Ok", service.getAllAcceptedCustomers());
    }



    @PutMapping(path = "/up/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadImagesAndPath(@RequestPart("nicf") MultipartFile nicf, @RequestPart("nicb") MultipartFile nicb, @RequestPart("licenceImg") MultipartFile licenceImg, @PathVariable String id) {
        try {
            String projectPath = String.valueOf(new File("D:/Project Zone/2nd Sem/Easy Car Rental/BackEnd/src/main/resources/static/images"));
            File uploadsDir = new File(projectPath + "/Customers");
            uploadsDir.mkdir();
            nicf.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + nicf.getOriginalFilename()));
            nicb.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + nicb.getOriginalFilename()));
            licenceImg.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + licenceImg.getOriginalFilename()));

            String nicfPath = projectPath + "/Customers/" + nicf.getOriginalFilename();
            String nicbPath = projectPath + "/Customers/" + nicb.getOriginalFilename();
            String licenceImgPath = projectPath + "/Customers/" + licenceImg.getOriginalFilename();

            service.uploadCustomerImages(nicfPath, nicbPath, licenceImgPath, id);

            return new ResponseUtil(200, "Uploaded", null);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseUtil(500, "Error", null);
        }
    }

    @GetMapping(path = "/count",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCountOfRegisteredCustomers(){
        return new ResponseUtil(200,"Ok",service.getCountOfCustomersRegistered());
    }

}