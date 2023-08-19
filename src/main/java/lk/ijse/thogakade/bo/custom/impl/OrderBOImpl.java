package lk.ijse.thogakade.bo.custom.impl;

import javafx.collections.FXCollections;
import lk.ijse.thogakade.bo.custom.OrderBO;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.dao.custom.OrderDAO;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.entity.Item;
import lk.ijse.thogakade.entity.Orders;

import java.util.List;

public class OrderBOImpl implements OrderBO {

    {
        itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEMDAO);
        orderDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDAO);
        customerDAO =DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMERDAO);
    }

    private final ItemDAO itemDAO;
    private final OrderDAO orderDAO;
    private final CustomerDAO customerDAO;

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
        List<OrderDTO>orderDTOS= FXCollections.observableArrayList();
        for (Orders orders : orderDAO.getAll()) {
            orderDTOS.add(new OrderDTO(orders.getId(),orders.getDescription(),orders.getOrderDateTime()));
        }
        return orderDTOS;
    }

    @Override
    public OrderDTO getItem(String id) {
        return null;
    }

    @Override
    public List<CustomerDTO> getCustomerId() {
        List<CustomerDTO> dtos = FXCollections.observableArrayList();
        for (Customer customer : customerDAO.getAll()) {
            dtos.add(new CustomerDTO(customer.getName(),customer.getAddress(),customer.getSalary(),customer.getId()));
        }
        return dtos;
    }

    @Override
    public CustomerDTO getCustomer(String value) {
        Customer item = customerDAO.getItem(value);
        return new CustomerDTO(item.getName(),item.getAddress(),item.getSalary(),item.getId());
    }

    @Override
    public ItemDTO getOrderItem(String value) {
        Item item = itemDAO.getItem(value);
        return new ItemDTO(item.getId(),item.getItemName(),item.getUnitPrice(),item.getQty());
    }

    @Override
    public List<ItemDTO> getItemIds() {
        List<ItemDTO> dtos = FXCollections.observableArrayList();
        for (Item item : itemDAO.getAll()) {
            dtos.add(new ItemDTO(item.getId(),item.getItemName(),item.getUnitPrice(),item.getQty()));
        }
        return dtos;
    }
}
