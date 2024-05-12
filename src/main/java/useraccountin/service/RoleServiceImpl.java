package useraccountin.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import useraccountin.configuration.HibernateUtil;
import useraccountin.model.Role;
import useraccountin.model.User;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Override
    public void add(Role entity) {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public void delete(Role entity) {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        }
    }

    @Override
    public Role get(int id) {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            return session.find(Role.class, id);
        }
    }

    @Override
    public List<Role> getAll() {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            return session.createQuery("from User", Role.class).list();
        }
    }

    @Override
    public void update(Role role, String name) {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.evict(role);
            role.setName(name);
            session.merge(role);
            transaction.commit();
        }
    }
}
