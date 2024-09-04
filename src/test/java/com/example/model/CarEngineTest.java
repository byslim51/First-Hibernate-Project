package com.example.model;

import org.example.myFirstHibernateProject.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class CarEngineTest {
    SessionFactory sessionFactory;
    Session session;

    @BeforeEach
    public void setup() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CarBrand.class)
                .addAnnotatedClass(MyCarEngine.class)
                .addAnnotatedClass(CarColor.class)
                .addAnnotatedClass(CarBodyType.class)
                .addAnnotatedClass(CarModel.class)
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();
        session = sessionFactory.getCurrentSession();
    }

    @Test
    public void getEngine() {
        session.beginTransaction();
        MyCarEngine entity = session.get(MyCarEngine.class, 1);
        Assert.assertEquals(entity.getName(), "engine_v5");
        session.getTransaction().commit();
    }

    @Test
    public void createNewEngine() {
        session.beginTransaction();
        MyCarEngine carEngine = new MyCarEngine("engine_v11");
        session.save(carEngine);


        MyCarEngine entity = session.get(MyCarEngine.class, carEngine.getId());
        Assert.assertEquals(entity.getName(), "engine_v11");
        session.delete(entity);
        session.getTransaction().commit();
    }

    @Test
    public void deleteNewEngine() {
        session.beginTransaction();
        MyCarEngine carEngine = new MyCarEngine("engine_v11");
        session.save(carEngine);

        MyCarEngine entity = session.get(MyCarEngine.class, carEngine.getId());
        if (entity != null) {
            session.delete(entity);
        }

        MyCarEngine check = session.get(MyCarEngine.class, carEngine.getId());
        session.getTransaction().commit();
        Assert.assertNull(check);
    }
}
