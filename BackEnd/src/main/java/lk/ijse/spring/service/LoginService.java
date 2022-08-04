package lk.ijse.spring.service;

import lk.ijse.spring.dto.LoginDTO;
import lk.ijse.spring.util.ResponseUtilLogin;

public interface LoginService {

    ResponseUtilLogin signIn (LoginDTO loginDTO);



}
