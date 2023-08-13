package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.configaration.StandardConfig;
import lk.ijse.thogakade.dao.custom.OrderDAO;
import lk.ijse.thogakade.entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class OrdersDAOImpl implements OrderDAO {
    @Override
    public boolean save(Orders dto) {
        return false;
    }

    @Override
    public boolean update(Orders dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Orders> getAll() {
        try (Session session = StandardConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Orders> query = criteriaBuilder.createQuery(Orders.class);
            query.from(Orders.class);
            List<Orders> resultList = session.createQuery(query).getResultList();
            transaction.commit();
            return resultList;
        }
    }

    @Override
    public Orders getItem(String id) {
        return null;
    }
}
