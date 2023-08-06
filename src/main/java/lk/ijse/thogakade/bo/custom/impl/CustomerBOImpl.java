package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.CustomerBo;
import lk.ijse.thogakade.entity.Customer;

import java.util.List;

public class CustomerBOImpl implements CustomerBo {
    @Override
    public boolean save(Customer dto) {
        return false;
    }

    @Override
    public boolean update(Customer dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getItem(String id) {
        return null;
    }
}
