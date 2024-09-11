package com.example.model;

import org.example.myFirstHibernateProject.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarModelTest {
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
    public void whenCRUDModelThenNotException() {
        session.beginTransaction();
        CarModel carModel = new CarModel();
        MyCarEngine carEngine = session.get(MyCarEngine.class, 1);
        CarBrand carBrand = session.get(CarBrand.class, 1);
        CarBodyType carBodyType = session.get(CarBodyType.class, 1);
        carModel.setName("Test");
        carModel.setCarEngine(carEngine);
        carModel.setBrand(carBrand);
        carModel.setBodyType(carBodyType);
        session.save(carModel);

        CarModel entity1 = session.get(CarModel.class, carModel.getId());
        Assert.assertEquals(entity1.getName(), "Test");
        Assert.assertEquals(entity1.getBrand().getName(), "Ford");
        Assert.assertEquals(entity1.getCarEngine().getName(), "engine_v15");
        Assert.assertEquals(entity1.getBodyType().getName(), "Hatchback");

        session.delete(carModel);
        Car deleteCar = session.get(Car.class, carModel.getId());
        session.getTransaction().commit();
        Assert.assertNull(deleteCar);
    }
}
