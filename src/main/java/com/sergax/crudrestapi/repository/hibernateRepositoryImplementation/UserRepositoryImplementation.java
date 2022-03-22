package com.sergax.crudrestapi.repository.hibernateRepositoryImplementation;

import com.sergax.crudrestapi.model.User;
import com.sergax.crudrestapi.repository.UserRepository;
import com.sergax.crudrestapi.utils.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImplementation implements UserRepository {
    private Transaction transaction = null;
    private User user = null;

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList();

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
            userList = session.createQuery("FROM User").getResultList();
//            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    @Override
    public User getById(Long id) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User WHERE id=:id");
            query.setParameter("id", id);
            List userList = query.getResultList();
            user = (User) userList.get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User updatedUser = session.get(User.class, user.getId());
            updatedUser.setUserName(user.getUserName());
            session.update(updatedUser);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User deletedUser = session.get(User.class, id);
            session.delete(deletedUser);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
