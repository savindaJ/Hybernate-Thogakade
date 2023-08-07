package lk.ijse.thogakade;

public class Launcher {
    public static void main(String[] args) {
        AppInitializer.main(args);

       /* try (Session session = StandardConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();

            Customer customer = new Customer("kamal","matara",120000.56,"C002");
            session.save(customer);
            transaction.commit();
            session.close();
        }*/
    }
}
