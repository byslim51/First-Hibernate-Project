package org.example.myFirstHibernateProject;

import org.example.myFirstHibernateProject.model.CarBodyType;
import org.example.myFirstHibernateProject.model.CarBrand;
import org.example.myFirstHibernateProject.model.CarColor;
import org.example.myFirstHibernateProject.model.MyCarEngine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.jaxb.cfg.spi.JaxbCfgHibernateConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CarShop {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CarBrand.class)
                .addAnnotatedClass(MyCarEngine.class)
                .addAnnotatedClass(CarColor.class)
                .addAnnotatedClass(CarBodyType.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            /**
             * SAVE
             */
//            CarBodyType entity = new CarBodyType("Sedan");
//            session.beginTransaction();
//            session.save(entity);
//            System.out.println(entity.getId());
//            session.getTransaction().commit();

            /**
             * GET
             */
//            session.beginTransaction();
//            CarColor entity = session.get(CarColor.class, 1);
//            System.out.println(entity.getName());
//            session.getTransaction().commit();

            /**
             * GET MULTIPLE (с условием)
             */
            session.beginTransaction();
            List<CarBodyType> entityList = session.createQuery("FROM CarBodyType").getResultList();
            for (CarBodyType entity1 : entityList) {
                System.out.println(entity1.getName());
            }
            session.getTransaction().commit();

            /**
             * DELETE
             */
//            session.beginTransaction();
//            CarBrand entity = session.get(CarBrand.class, 6);
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



        } finally {
            sessionFactory.close();
        }
    }
}
