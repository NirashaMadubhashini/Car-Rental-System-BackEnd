package lk.ijse.spring.service.impl;


import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.entity.Payment;
import lk.ijse.spring.repo.PaymentRepo;
import lk.ijse.spring.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo repo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void savePayment(PaymentDTO dto) {
        if (!repo.existsById(dto.getPaymentId())) {
//            repo.save(mapper.map(dto,Payment.class));
        } else {
            throw new RuntimeException("Customer Already Exists");
        }
    }


    @Override
    public void updatePayment(PaymentDTO dto) {
        if (repo.existsById(dto.getPaymentId())) {
//            repo.save(mapper.map(dto, Payment.class));
        } else {
            throw new RuntimeException("No Such Payment To Update");
        }
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return mapper.map(repo.findAll(), new TypeToken<List<PaymentDTO>>() {
        }.getType());
    }
}
