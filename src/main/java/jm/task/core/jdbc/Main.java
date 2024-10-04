package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();
        userDao.saveUser("Igor", "Ilkov", (byte) 38);
        System.out.println("User с именем — Igor добавлен в базу данных");
        userDao.saveUser("Vasya", "Vaselek", (byte) 39);
        System.out.println("User с именем — Vasya добавлен в базу данных");
        userDao.saveUser("Mitya", "Vaselek", (byte) 40);
        System.out.println("User с именем — Mitya добавлен в базу данных");
        userDao.saveUser("Grisha", "Vaselek", (byte) 41);
        System.out.println("User с именем — Grisha добавлен в базу данных");
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
