package org.example.myFirstHibernateProject;

import org.example.myFirstHibernateProject.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CarShop {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CarBrand.class)
                .addAnnotatedClass(MyCarEngine.class)
                .addAnnotatedClass(CarColor.class)
                .addAnnotatedClass(CarBodyType.class)
                .addAnnotatedClass(CarModel.class)
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            /**
             * CREATE
             */
//            session.beginTransaction();
//            Car car = new Car();
//            CarColor carColor = session.get(CarColor.class, 3);
//            CarModel carModel = session.get(CarModel.class, 3);
//            car.setColor(carColor);
//            car.setModel(carModel);
//            System.out.println(car.getColor().getName());
//            session.save(car);
//            session.getTransaction().commit();

//            session.beginTransaction();
//            MyCarEngine car = new MyCarEngine("engine");
//            session.save(car);
//            session.getTransaction().commit();

            /**
             * GET
             */
//            session.beginTransaction();
//            Car entity1 = session.get(Car.class, 1);
//            System.out.println(entity1.getColor().getName());
//            session.getTransaction().commit();

            /**
             * GET MULTIPLE (с условием)
             */
//            session.beginTransaction();
//            List<CarModel> entityList = session.createQuery("FROM CarModel").getResultList();
//            for (CarModel entity1 : entityList) {
//                System.out.println("Model: " + entity1.getName());
//                System.out.println("Brand: " + entity1.getBrand().getName());
//            }
//            session.getTransaction().commit();

            /**
             * DELETE
             */
//            session.beginTransaction();
//            CarBrand entity = session.get(CarBrand.class, 1);
//           if (entity != null ){
//                session.delete(entity);
//            }
//            session.getTransaction().commit();

            /**
             * DELETE MULTIPLE (с условием)
             */
//            session.beginTransaction();
//            CarBrand entity = session.get(CarBrand.class, 6);
//            session.createQuery("delete CarBrand where name LIKE 'BMW'").executeUpdate();
//            session.getTransaction().commit();

            session.beginTransaction();
            CarBodyType carBodyType = new CarBodyType("Hatchback");
            session.save(carBodyType);

            CarBodyType entity = session.get(CarBodyType.class, carBodyType.getId());
//        Assert.assertEquals(entity.getName(), "Hatchback");
//        session.delete(entity);
            session.getTransaction().commit();



        } finally {
            sessionFactory.close();
        }
    }
}
