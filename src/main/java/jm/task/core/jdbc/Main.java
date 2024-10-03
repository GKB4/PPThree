package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoHibernateImpl userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();
        userDao.saveUser("Igor", "Ilkov", (byte)38);
        System.out.println("User с именем — Igor добавлен в базу данных");
        userDao.saveUser("Vasya", "Vaselek", (byte)39);
        System.out.println("User с именем — Vasya добавлен в базу данных");
        userDao.saveUser("Mitya", "Vaselek", (byte)40);
        System.out.println("User с именем — Mitya добавлен в базу данных");
        userDao.saveUser("Grisha", "Vaselek", (byte)41);
        System.out.println("User с именем — Grisha добавлен в базу данных");
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();

        //------------JDBC-----
        /*
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();

        userDao.saveUser("Igor", "Ilkov", (byte) 38);
        System.out.println("User с именем — Igor добавлен в базу данных");
        userDao.saveUser("Stepan", "Stepanov", (byte) 39);
        System.out.println("User с именем — Stepan добавлен в базу данных");
        userDao.saveUser("Sergey ", "Sergeev", (byte) 40);
        System.out.println("User с именем — Sergey добавлен в базу данных");
        userDao.saveUser("Petr ", "Petrov", (byte) 41);
        System.out.println("User с именем — Petr добавлен в базу данных");

        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
        */
    }
}
