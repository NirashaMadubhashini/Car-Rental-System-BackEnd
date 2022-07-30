package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/driver")
@CrossOrigin
public class DriverController {
    @Autowired
    DriverService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDrivers() {
        return new ResponseUtil(200, "Ok", service.getAllDrivers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@RequestBody DriverDTO dto) {
        if (!(dto.getDid().equals(""))){
            service.saveDriver(dto);
            return new ResponseUtil(200, "Saved", null);
        }else {
            return new ResponseUtil(404, "NotSaved", null);
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody DriverDTO dto) {
        if (!(dto.getDid().equals(""))){
            service.updateDriver(dto);
            return new ResponseUtil(200, "Updated", null);
        }else {
            return new ResponseUtil(404, "NotUpdated", null);
        }
    }

    @DeleteMapping(params = {"did"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(@RequestParam String did) {
        if (!(did.equals(""))){
            service.deleteDriver(did);
            return new ResponseUtil(200, "Deleted", null);
        }else {
            return new ResponseUtil(404, "NotDeleted", null);
        }
    }

    @GetMapping(path = "/{did}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriver(@PathVariable String did) {
        return new ResponseUtil(200, "Ok", service.searchDriver(did));
    }


    @GetMapping(path = "/getAllAvailableDrivers",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAvailableDrivers(){
        return new ResponseUtil(200,"Ok",service.getAllAvailableDrivers());
    }

    @GetMapping(path = "/getAllNonAvailableDrivers",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllNonAvailableDrivers(){
        return new ResponseUtil(200,"Ok",service.getAllNonAvailableDrivers());
    }

    @GetMapping(path = "/count/{availability}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCountOfCustomersByAvailability(@PathVariable boolean availability){
        return new ResponseUtil(200,"Ok",service.getCountOfDriversByStatus(availability));
    }
}
