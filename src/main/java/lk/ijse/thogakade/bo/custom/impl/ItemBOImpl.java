package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.ItemBO;
import lk.ijse.thogakade.entity.Item;

import java.util.List;

public class ItemBOImpl implements ItemBO {
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
