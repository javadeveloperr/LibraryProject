package org.example;
import org.example.config.Config;
import org.example.controller.MenuController;
import org.example.db.Database;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();

        Database.initTable();
        Database.initAdmin();

        // TODO  at home
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        InitDatabase initDataBase = (InitDatabase) context.getBean("initDatabase");
//
//        initDataBase.adminInit();
//        initDataBase.addCompanyCard();
//
//        AuthController authController = (AuthController) context.getBean("authController");
//        authController.start();    }
        MenuController menuController = (MenuController) context.getBean("menuController");
    menuController.mainMenu();
    }

}