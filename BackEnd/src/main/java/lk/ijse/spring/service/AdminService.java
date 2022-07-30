package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    void saveAdmin(AdminDTO dto);

    boolean findAdminByUserName(String username);

    boolean findAdminByPassWord(String password);

    List<AdminDTO> getAllAdmins();

}
