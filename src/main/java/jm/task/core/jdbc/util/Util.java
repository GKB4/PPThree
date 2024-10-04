package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/pptask2";
    private static final String user = "root";
    private static final String password = "123456";

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties prop = new Properties();
                prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
                prop.setProperty("hibernate.connection.url", url);
                prop.setProperty("hibernate.connection.username", user);
                prop.setProperty("hibernate.connection.password", password);
                prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
                prop.setProperty("hibernate.hbm2ddl.auto", "update");
                prop.setProperty("hibernate.show_sql", "true");
                prop.setProperty("hibernate.format_sql", "true");
                prop.setProperty("hibernate.use_sql_comments", "true");

                Configuration cfg = new Configuration();
                cfg.addAnnotatedClass(jm.task.core.jdbc.model.User.class);
                cfg.setProperties(prop);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(cfg.getProperties()).build();

                sessionFactory = cfg.buildSessionFactory(serviceRegistry);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
