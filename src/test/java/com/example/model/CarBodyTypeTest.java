package com.example.model;

import org.example.myFirstHibernateProject.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class CarBodyTypeTest {
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
    public void getBodyType() {
        session.beginTransaction();
        CarBodyType entity = session.get(CarBodyType.class, 1);
        Assert.assertEquals(entity.getName(), "Cruiser");
        session.getTransaction().commit();
    }

    @Test
    public void createNewBodyType() {
        session.beginTransaction();
        CarBodyType carBodyType = new CarBodyType("Hatchback");
        session.save(carBodyType);

        CarBodyType entity = session.get(CarBodyType.class, carBodyType.getId());
        Assert.assertEquals(entity.getName(), "Hatchback");
        session.delete(entity);
        session.getTransaction().commit();
    }

    @Test
    public void deleteNewBodyType() {
        session.beginTransaction();
        CarBodyType carBodyType = new CarBodyType("Hatchback");
        session.save(carBodyType);

        CarBodyType entity = session.get(CarBodyType.class, carBodyType.getId());
        if (entity != null ){
            session.delete(entity);
        }

        CarBodyType check = session.get(CarBodyType.class, carBodyType.getId());
        session.getTransaction().commit();
        Assert.assertNull(check);
    }

    @Test
    public void unCorrectGetCheck() {
        session.beginTransaction();
        Assertions.assertThrows(NullPointerException.class, () -> {
            CarBodyType entity = session.get(CarBodyType.class, 100);
            entity.getName();
        });
        session.getTransaction().commit();
    }
}
