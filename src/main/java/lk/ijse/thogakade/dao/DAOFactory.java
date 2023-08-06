package lk.ijse.thogakade.dao;

import lk.ijse.thogakade.bo.custom.impl.CustomerBOImpl;
import lk.ijse.thogakade.dao.custom.impl.ItemDAOImpl;
import lk.ijse.thogakade.dao.custom.impl.OrderDetailDAOImpl;
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
                return (T) new CustomerBOImpl();
            case ORDERDAO:
                return (T) new OrdersDAOImpl();
            case ORDERDETAILDAO:
                return (T) new OrderDetailDAOImpl();
            default:
                return null;
        }
    }
}
