package lesson2;

import lesson1.Product;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ProductDAO {
    private static SessionFactory sessionFactory;
    private Session session = createSessionFactory().openSession();
    private Transaction tr = null;

    public void saveAll(List<Product> products){

        try {
            tr = session.getTransaction();
            tr.begin();

            for (Product product : products) {
                session.save(product);
            }
            tr.commit();

            System.out.println("Save is done");
        } catch (HibernateError e){
            System.err.println("Save is failed");
            System.err.println(e.getMessage());

            if (tr != null){
                tr.rollback();
            }
        }finally {
            if (session != null)
                session.close();
        }

    }

    public void save(Product product){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            session.save(product);

            tr.commit();

            System.out.println("Save is done");
        } catch (HibernateError e){
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }
    }

    public void update(Product product){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            session.update(product);

            tr.commit();

            System.out.println("Update is done");
        } catch (HibernateError e){
            System.err.println("Update is failed");
            System.err.println(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }
    }

    public void delete(Product product){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            session.delete(product);

            tr.commit();

            System.out.println("Delete is done");
        } catch (HibernateError e){
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());

        }finally {
            if (session != null)
                session.close();
        }
    }

    public void updateAll(List<Product> products){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            for (Product product : products) {
                session.update(product);
            }
            tr.commit();

            System.out.println("Update is done");
        } catch (HibernateError e){
            System.err.println("Update is failed");
            System.err.println(e.getMessage());

            if (tr != null){
                tr.rollback();
            }
        }finally {
            if (session != null)
                session.close();
        }
    }

    public void deleteAll(List<Product> products){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            for (Product product : products) {
                session.delete(product);
            }
            tr.commit();

            System.out.println("Delete is done");
        } catch (HibernateError e){
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());

            if (tr != null){
                tr.rollback();
            }
        }finally {
            if (session != null)
                session.close();
        }
    }



    public static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory =  new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}
