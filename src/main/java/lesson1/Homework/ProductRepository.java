package lesson1.Homework;

import lesson1.HibernateUtils;
import lesson1.Product;
import org.hibernate.Session;

public class ProductRepository {
    public static void main(String[] args) {
        Product product = new Product(22222, "Test222Test", "Test22222", 500);
        //save(product);
        //delete(10);
        update(product);
    }

    static void save(Product product){
        Session session = new HibernateUtils().createSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(product);
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }


    static void delete(long id){
        Session session = new HibernateUtils().createSessionFactory().openSession();
        session.getTransaction().begin();
        Product product = new Product();
        product.setId(id);
        System.out.println(product.toString());
        session.delete(product);
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }

    static void update(Product product){
        Session session = new HibernateUtils().createSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(product);
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }
}
