package useraccountin.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory instance;

    private HibernateUtil() {
    }

    public static SessionFactory getInstance() {
        if (instance == null) {
            instance = new Configuration().buildSessionFactory();
        }
        return instance;
    }
}
