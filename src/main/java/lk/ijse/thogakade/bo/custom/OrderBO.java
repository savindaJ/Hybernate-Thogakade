package lk.ijse.thogakade.bo.custom;

import lk.ijse.thogakade.bo.CrudBO;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.entity.Orders;

import java.util.List;

public interface OrderBO extends CrudBO<OrderDTO,String> {
    List<CustomerDTO> getCustomerId();

    CustomerDTO getCustomer(String value);

    ItemDTO getOrderItem(String value);

    List<ItemDTO> getItemIds();
}
