package com.fullstack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fullstack.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void signUp(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(user); // Save the user entity
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean signIn(String userEmailId, String userPassword) {
        Session session = sessionFactory.openSession();
        boolean flag = false;

        try {
            @SuppressWarnings("unchecked")
            List<User> users = session.createQuery("from User").list();

            for (User user : users) {
                if (user.getUserEmailId().equals(userEmailId) &&
                        user.getUserPassword().equals(userPassword)) {
                    flag = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }

        return flag;
    }
}
