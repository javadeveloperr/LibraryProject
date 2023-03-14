package org.example;

import org.example.config.Config;
import org.example.controller.MenuController;
import org.example.db.Database;
import org.example.repository.StudentRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {
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