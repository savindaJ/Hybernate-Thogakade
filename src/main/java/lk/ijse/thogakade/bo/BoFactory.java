package lk.ijse.thogakade.bo;

import lk.ijse.thogakade.bo.custom.impl.CustomerBOImpl;
import lk.ijse.thogakade.bo.custom.impl.ItemBOImpl;
import lk.ijse.thogakade.bo.custom.impl.OrderBOImpl;

public class BoFactory {
    private static BoFactory factory;

    private BoFactory(){}

    public static BoFactory getInstance(){
        return factory == null ? new BoFactory() : factory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM,ORDER
    }
    public <T extends SuperBO>T getBo(BOTypes types){
        switch (types){
            case ITEM:
                return (T) new ItemBOImpl();
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case ORDER:
                return (T) new OrderBOImpl();
            default:
                return null;
        }
    }
}
