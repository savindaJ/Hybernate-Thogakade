package lk.ijse.thogakade.dao.custom;

import lk.ijse.thogakade.dao.CrudDAO;
import lk.ijse.thogakade.entity.Customer;

import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    List<Customer> getAllJPQL();
    Customer getObjectInJPQL(String id);
}
