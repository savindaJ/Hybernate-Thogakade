package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.ItemBO;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEMDAO);

    @Override
    public boolean save(ItemDTO dto) {
        return itemDAO.save(new Item(
                dto.getItemCode(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getQty())
        );
    }

    @Override
    public boolean update(ItemDTO dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return itemDAO.delete(id);
    }

    @Override
    public List<ItemDTO> getAll() {
        List<ItemDTO> itemDTOLIst = new ArrayList<>();
        for (Item item : itemDAO.getAll()) {
            itemDTOLIst.add(new ItemDTO(
                    item.getItemCode(),
                    item.getItemDescription(),
                    item.getPrice(),
                    item.getQty())
            );
        }
        return itemDTOLIst;
    }

    @Override
    public ItemDTO getItem(String id) {
        return null;
    }
}
