package lk.ijse.thogakade.configaration;

import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.entity.Item;
import lk.ijse.thogakade.entity.OrderDetail;
import lk.ijse.thogakade.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StandardConfig {
    private static final SessionFactory factory;
    private static StandardConfig config;

    static {
         factory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Item.class)
                 .addAnnotatedClass(Orders.class)
                 .addAnnotatedClass(OrderDetail.class)
                .buildSessionFactory();
    }

    private StandardConfig(){}

    public static StandardConfig getInstance(){
        return config == null ? new StandardConfig() : config;
    }

    public Session getSession(){
        return factory.openSession();
    }
}
