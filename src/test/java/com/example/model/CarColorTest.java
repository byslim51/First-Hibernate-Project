package com.example.model;

import org.example.myFirstHibernateProject.model.Car;
import org.example.myFirstHibernateProject.model.CarColor;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.myFirstHibernateProject.model.*;


public class CarColorTest {
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
    public void whenCRUDCarColorThenNotException() {
        session.beginTransaction();
        CarColor carColor = new CarColor("Orange");
        session.save(carColor);

        CarColor entity = session.get(CarColor.class, carColor.getId());
        Assert.assertEquals(entity.getName(), "Orange");

        session.delete(carColor);
        CarColor entityDelete = session.get(CarColor.class, carColor.getId());
        Assert.assertNull(entityDelete);
        session.getTransaction().commit();
    }
}
