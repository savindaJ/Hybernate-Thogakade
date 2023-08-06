package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.OrderBO;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.entity.Orders;

import java.util.List;

public class OrderBOImpl implements OrderBO {

    @Override
    public boolean save(OrderDTO dto) {
        return false;
    }

    @Override
    public boolean update(OrderDTO dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<OrderDTO> getAll() {
        return null;
    }

    @Override
    public OrderDTO getItem(String id) {
        return null;
    }
}
