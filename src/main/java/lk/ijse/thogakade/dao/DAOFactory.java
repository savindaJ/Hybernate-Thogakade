package lk.ijse.thogakade.dao;

import lk.ijse.thogakade.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.thogakade.dao.custom.impl.ItemDAOImpl;
import lk.ijse.thogakade.dao.custom.impl.OrdersDAOImpl;

public class DAOFactory {

    private static DAOFactory factory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return factory == null ? new DAOFactory() : factory;
    }

    public enum DAOTypes{
        CUSTOMERDAO,ITEMDAO,ORDERDAO,ORDERDETAILDAO
    }

    public <T extends SuperDAO>T getDAO(DAOTypes types){
        switch (types){
            case ITEMDAO:
                return (T) new ItemDAOImpl();
            case CUSTOMERDAO:
                return (T) new CustomerDAOImpl();
            case ORDERDAO:
                return (T) new OrdersDAOImpl();
            default:
                return null;
        }
    }
}
