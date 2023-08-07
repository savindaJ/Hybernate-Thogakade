package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.configaration.StandardConfig;
import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    {
        session = StandardConfig.getInstance().getSession();
    }
    Session session;
    @Override
    public boolean save(Customer entity) {
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer(entity.getName(), entity.getAddress(), entity.getSalary(), entity.getId());
        Serializable save = session.save(customer);
        transaction.commit();
        session.close();
        return save != null;
    }

    @Override
    public boolean update(Customer entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getItem(String id) {
        return null;
    }
}
