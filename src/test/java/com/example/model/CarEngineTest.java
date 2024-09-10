package com.example.model;

import org.example.myFirstHibernateProject.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
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
    public void whenCRUDCarEngineThenNotException() {
        session.beginTransaction();
        MyCarEngine carEngine = new MyCarEngine("engine_v16");
        session.save(carEngine);

        MyCarEngine entity = session.get(MyCarEngine.class, carEngine.getId());
        Assert.assertEquals(entity.getName(), "engine_v16");

        session.delete(carEngine);
        MyCarEngine entityDelete = session.get(MyCarEngine.class, carEngine.getId());
        Assert.assertNull(entityDelete);
        session.getTransaction().commit();
    }
}
