package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.dao.custom.OrderDetailDAO;
import lk.ijse.thogakade.entity.OrderDetail;

import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean save(OrderDetail dto) {
        return false;
    }

    @Override
    public boolean update(OrderDetail dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<OrderDetail> getAll() {
        return null;
    }

    @Override
    public OrderDetail getItem(String id) {
        return null;
    }
}
