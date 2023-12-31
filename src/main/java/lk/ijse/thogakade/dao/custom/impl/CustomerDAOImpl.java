package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.configaration.StandardConfig;
import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean save(Customer entity) {
        Session session = StandardConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Serializable save = session.save(entity);
        transaction.commit();
        session.close();
        return save != null;
    }

    @Override
    public boolean update(Customer entity) {
        Session session = StandardConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) {
        Session session = StandardConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, Integer.parseInt(id));
        session.delete(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Customer> getAll() {
        Session session = StandardConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
        query.from(Customer.class);
        List<Customer> resultList = session.createQuery(query).getResultList();
        transaction.commit();
        session.close();
        return resultList;
    }

    @Override
    public Customer getItem(String id) {
        Session session = StandardConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, Integer.parseInt(id));
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public List<Customer> getAllJPQL() {
        Session session = StandardConfig.getInstance().getSession();
        String sql = "SELECT C FROM Customer AS C";
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public Customer getObjectInJPQL(String id) {
        String sql = "SELECT C FROM Customer AS C WHERE C.id =: customerID";
        try (Session session = StandardConfig.getInstance().getSession()) {
            Query query = session.createQuery(sql);
            query.setParameter("customerID",id);
            return (Customer) query.getSingleResult();
        }
    }
}
