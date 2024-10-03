package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
    /*     try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS user (id INT, name VARCHAR(20) not null, lastname VARCHAR(20) not null, age INT not null, PRIMARY KEY (id))";
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    */
        new UserDaoJDBCImpl().createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        new UserDaoJDBCImpl().dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            User user = new User(name, lastName, age);
            session.persist(user);
            session.flush();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(session.find(User.class, id));
            session.flush();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<User>();
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            userList = session.createQuery("FROM User", User.class).list();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        for (User user : getAllUsers()) {
            removeUserById(user.getId());
        }
    }
}
