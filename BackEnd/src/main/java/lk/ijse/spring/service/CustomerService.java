package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);

    void changeCustomerStatus(String type,String nicNo);

    void updateCustomer(CustomerDTO dto);

    CustomerDTO searchCustomer(String nicNo);

    void deleteCustomer(String nicNo);

    List<CustomerDTO> getAllCustomers();

    List<CustomerDTO> getAllPendingCustomers();

    List<CustomerDTO> getAllAcceptedCustomers();

    void uploadCustomerImages(String nicfPath, String nicbPath, String licenceImgPath, String id);

    int getCountOfCustomersRegistered();
}
