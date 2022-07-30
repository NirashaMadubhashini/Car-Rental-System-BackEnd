package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("api/v1/admin/car")
@CrossOrigin
public class CarController {
    @Autowired
    CarService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCars() {
        return new ResponseUtil(200, "Ok", service.getAllCars());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(@RequestBody CarDTO dto) {
        if (!(dto.getRegistrationNO().equals(""))){
            service.saveCar(dto);
            return new ResponseUtil(200, "Saved", null);
        }else {
            return new ResponseUtil(404, "NotSaved", null);
        }

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCar(@RequestBody CarDTO dto) {
        if (!(dto.getRegistrationNO().equals(""))){
            service.updateCar(dto);
            return new ResponseUtil(200, "Updated", null);
        }else {
            return new ResponseUtil(404, "NotUpdated", null);
        }
    }

    @DeleteMapping(params = {"registrationNO"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCar(@RequestParam  String registrationNO) {
        if (!(registrationNO.equals(""))){
            service.deleteCar(registrationNO);
            return new ResponseUtil(200, "Deleted", null);
        }else {
            return new ResponseUtil(404, "NotDeleted", null);
        }
    }

    @GetMapping(path = "/{registrationNO}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCar(@PathVariable  String registrationNO) {
        return new ResponseUtil(200, "Ok", service.searchCar(registrationNO));
    }

//    @PutMapping(path = "/{registrationNO}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseUtil updateCar(@PathVariable String registrationNO) {
//        service.updateCar(registrationNO);
//        return new ResponseUtil(200, "Ok", null);
//    }

    @GetMapping(path = "/getByStatus/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCarsByStatus(@PathVariable String status) {
        return new ResponseUtil(200, "Ok", service.getAllCarsByStatus(status));
    }

    @GetMapping(path = "/count/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCountOfCarsByStatus(@PathVariable String status) {
        return new ResponseUtil(200, "Ok", service.getCountOfCarsByStatus(status));
    }

    @PutMapping(path = "/up/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadImagesAndPath(@RequestPart("frontImg") MultipartFile frontImg, @RequestPart("backImg") MultipartFile backImg, @RequestPart("interImg") MultipartFile interImg, @RequestPart("sideImg") MultipartFile sideImg, @PathVariable long id) {
        try {
            String projectPath = String.valueOf(new File("D:/Project Zone/2nd Sem/Easy Car Rental/BackEnd/src/main/resources/static/images"));
            File uploadsDir = new File(projectPath + "/Cars");
            uploadsDir.mkdir();
            frontImg.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + frontImg.getOriginalFilename()));
            backImg.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + backImg.getOriginalFilename()));
            interImg.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + interImg.getOriginalFilename()));
            sideImg.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + sideImg.getOriginalFilename()));

            String frontImgPath = projectPath + "/Cars/" + frontImg.getOriginalFilename();
            String backImgPath = projectPath + "/Cars/" + backImg.getOriginalFilename();
            String interImgPath = projectPath + "/Cars/" + interImg.getOriginalFilename();
            String sideImgPath = projectPath + "/Cars/" + sideImg.getOriginalFilename();

//            service.updateCarFilePaths(frontImgPath, backImgPath, interImgPath, sideImgPath, id);

            return new ResponseUtil(200, "Uploaded", null);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseUtil(500, "Error", null);
        }
    }
}
