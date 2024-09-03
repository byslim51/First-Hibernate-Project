package com.example.model;

import org.example.myFirstHibernateProject.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CarTest {
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
    public void getCarModelAndColor(){
        session.beginTransaction();
        Car entity1 = session.get(Car.class, 1);
        session.getTransaction().commit();
        Assert.assertEquals(entity1.getColor().getName(), "Red");
        Assert.assertEquals(entity1.getModel().getName(), "Corolla 2");
    }

    @Test
    public void createCarModelAndColor() {
        session.beginTransaction();
            Car car = new Car();
            CarColor carColor = session.get(CarColor.class, 3);
            CarModel carModel = session.get(CarModel.class, 1);
            car.setColor(carColor);
            car.setModel(carModel);
            session.save(car);

        Car entity1 = session.get(Car.class, car.getId());
        Assert.assertEquals(entity1.getColor().getName(), "Red");
        Assert.assertEquals(entity1.getModel().getName(), "Corolla 2");

        session.delete(car);
        Car deleteCar = session.get(Car.class, car.getId());
        session.getTransaction().commit();
        Assert.assertNull(deleteCar);
    }

    @Test
    public void deleteCarModelAndColor() {
        session.beginTransaction();
        Car car = new Car();
        CarColor carColor = session.get(CarColor.class, 3);
        CarModel carModel = session.get(CarModel.class, 1);
        car.setColor(carColor);
        car.setModel(carModel);
        session.save(car);

        session.delete(car);
        Car checkDeleteCar = session.get(Car.class, car.getId());
        Assert.assertNull(checkDeleteCar);
        session.getTransaction().commit();
    }
}
