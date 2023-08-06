package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.entity.Item;

import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item dto) {
        return false;
    }

    @Override
    public boolean update(Item dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Item> getAll() {
        return null;
    }

    @Override
    public Item getItem(String id) {
        return null;
    }
}
