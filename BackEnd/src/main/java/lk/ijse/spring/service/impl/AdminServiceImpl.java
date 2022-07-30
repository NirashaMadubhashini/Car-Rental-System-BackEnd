package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl  implements AdminService {
    @Autowired
    AdminRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveAdmin(AdminDTO dto) {
        if (!repo.existsByAdminId(dto.getAdminId())) {
            repo.save(mapper.map(dto, Admin.class));
        } else {
            throw new RuntimeException("Admin Already Exists");
        }
    }


    @Override
    public boolean findAdminByUserName(String username) {
        return repo.findAdminByUsername(username).isPresent();
    }

    @Override
    public boolean findAdminByPassWord(String password) {
        return repo.findAdminByPassword(password).isPresent();
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        return mapper.map(repo.findAll(), new TypeToken<List<AdminDTO>>() {
        }.getType());
    }

}
