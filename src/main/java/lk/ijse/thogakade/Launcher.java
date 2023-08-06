package lk.ijse.thogakade;

import lk.ijse.thogakade.configaration.Config;
import org.hibernate.Session;

public class Launcher {
    public static void main(String[] args) {
        /*AppInitializer.main(args);*/

        try (Session session = Config.getInstance().getSession()) {
            System.out.println("config");
        }
    }
}
