package lk.ijse.thogakade.configaration;

import lk.ijse.thogakade.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Config {
    private static Config config;

    private static SessionFactory factory;

    static {
        factory = new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
    }

    public static Config getInstance(){
        return config == null ? new Config() : config;
    }

    public Session getSession(){
        return factory.openSession();
    }
}
