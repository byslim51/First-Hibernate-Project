package com.example.model;

import org.example.myFirstHibernateProject.model.Car;
import org.example.myFirstHibernateProject.model.CarColor;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
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
    public void getColor() {
        session.beginTransaction();
        CarColor entity = session.get(CarColor.class, 1);
        Assert.assertEquals(entity.getName(), "White");
        session.getTransaction().commit();
    }

    @Test
    public void createNewColor() {
        session.beginTransaction();
            CarColor carColor = new CarColor("Purple");
            session.save(carColor);


        CarColor entity = session.get(CarColor.class, carColor.getId());
        Assert.assertEquals(entity.getName(), "Purple");
        session.delete(entity);
        session.getTransaction().commit();
    }

    @Test
    public void deleteNewColor() {
        session.beginTransaction();
        CarColor carColor = new CarColor("Purple");
        session.save(carColor);

        CarColor entity = session.get(CarColor.class, carColor.getId());
           if (entity != null ){
                session.delete(entity);
            }

        CarColor entity1 = session.get(CarColor.class, carColor.getId());
        session.getTransaction().commit();
        Assert.assertNull(entity1);
    }
}
