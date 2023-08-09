package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.configaration.StandardConfig;
import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item entity) {
        try (Session session = StandardConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Serializable save = session.save(entity);
            transaction.commit();
            return save != null;
        }
    }

    @Override
    public boolean update(Item entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        try (Session session = StandardConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Item item = session.get(Item.class, id);
            session.delete(item);
            transaction.commit();
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public List<Item> getAll() {
        try (Session session = StandardConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Item> query = criteriaBuilder.createQuery(Item.class);
            query.from(Item.class);
            List<Item> resultList = session.createQuery(query).getResultList();
            transaction.commit();
            return resultList;
        }
    }

    @Override
    public Item getItem(String id) {
        return null;
    }
}
