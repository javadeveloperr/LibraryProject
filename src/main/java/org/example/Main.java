package org.example;

import org.example.controller.MenuController;
import org.example.db.Database;
import org.example.db.InitDatabase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        Database.initTable();
        Database.initAdmin();

        // TODO  at home
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        InitDatabase initDataBase = (InitDatabase) context.getBean("initDatabase");
//
//        initDataBase.adminInit();
//        initDataBase.addCompanyCard();
//
//        AuthController authController = (AuthController) context.getBean("authController");
//        authController.start();    }

        MenuController menuController=new MenuController();
        menuController.mainMenu();
    }
}