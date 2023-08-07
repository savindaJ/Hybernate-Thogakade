package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.CustomerBo;
import lk.ijse.thogakade.configaration.StandardConfig;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.entity.Customer;
import org.hibernate.Session;

import java.util.List;

public class CustomerBOImpl implements CustomerBo {
    CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMERDAO);

    @Override
    public boolean save(CustomerDTO dto) {
        return customerDAO.save(new Customer(dto.getName(),dto.getAddress(),dto.getSalary(),dto.getId()));
    }

    @Override
    public boolean update(CustomerDTO dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<CustomerDTO> getAll() {
        return null;
    }

    @Override
    public CustomerDTO getItem(String id) {
        return null;
    }
}
