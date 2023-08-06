package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.dao.custom.OrderDAO;
import lk.ijse.thogakade.entity.Orders;

import java.util.List;

public class OrdersDAOImpl implements OrderDAO {
    @Override
    public boolean save(Orders dto) {
        return false;
    }

    @Override
    public boolean update(Orders dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Orders> getAll() {
        return null;
    }

    @Override
    public Orders getItem(String id) {
        return null;
    }
}
