package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.CustomerBo;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBo {

    private final CustomerDAO customerDAO;

    {
        customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMERDAO);
    }

    @Override
    public boolean save(CustomerDTO dto) {
        return customerDAO.save(new Customer(
               dto.getName(),
                dto.getAddress(),
                dto.getSalary(),
                dto.getId())
        );
    }

    @Override
    public boolean update(CustomerDTO dto) {
        return customerDAO.update(new Customer(
                dto.getName(),
                dto.getAddress(),
                dto.getSalary(),
                dto.getId())
        );
    }

    @Override
    public boolean delete(String id) {
        return customerDAO.delete(id);
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customerDAO.getAll()) {
            customerDTOS.add(new CustomerDTO(
                    customer.getName(),
                    customer.getAddress(),
                    customer.getSalary(),
                    customer.getId())
            );
        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO getItem(String id) {
        Customer item = customerDAO.getItem(id);
        return new CustomerDTO(
                item.getName(),
                item.getAddress(),
                item.getSalary(),
                item.getId()
        );
    }
}
