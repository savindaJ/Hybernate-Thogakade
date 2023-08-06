package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.CustomerBo;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.entity.Customer;

import java.util.List;

public class CustomerBOImpl implements CustomerBo {

    @Override
    public boolean save(CustomerDTO dto) {
        return false;
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
