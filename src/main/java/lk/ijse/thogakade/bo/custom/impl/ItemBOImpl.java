package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.ItemBO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.entity.Item;

import java.util.List;

public class ItemBOImpl implements ItemBO {

    @Override
    public boolean save(ItemDTO dto) {
        return false;
    }

    @Override
    public boolean update(ItemDTO dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<ItemDTO> getAll() {
        return null;
    }

    @Override
    public ItemDTO getItem(String id) {
        return null;
    }
}
