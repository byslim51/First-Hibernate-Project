package com.example.model;

import org.example.myFirstHibernateProject.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.myFirstHibernateProject.model.CarBrand;

public class CarBrandTest {
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
    public void whenCRUDCarBrandThenNotException() {
        session.beginTransaction();
        CarBrand carBrand = new CarBrand("Porsche");
        session.save(carBrand);

        CarBrand entity = session.get(CarBrand.class, carBrand.getId());
        Assert.assertEquals(entity.getName(), "Porsche");

        session.delete(carBrand);
        CarBrand entityDelete = session.get(CarBrand.class, carBrand.getId());
        Assert.assertNull(entityDelete);
        session.getTransaction().commit();
    }
}
