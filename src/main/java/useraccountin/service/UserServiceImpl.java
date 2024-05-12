package useraccountin.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import useraccountin.configuration.HibernateUtil;
import useraccountin.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public void add(User entity) {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public void delete(User entity) {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        }
    }

    @Override
    public User get(int id) {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            return session.find(User.class, id);
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }

    @Override
    public void update(User user, String password) {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.evict(user);
            user.setPassword(password);
            session.merge(user);
            transaction.commit();
        }
    }
}
