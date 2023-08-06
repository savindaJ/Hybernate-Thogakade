package lk.ijse.thogakade.dao;

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
                return
        }
    }
}
