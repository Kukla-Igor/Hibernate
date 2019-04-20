package lesson2.homework.SQL;

import lesson1.Product;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAO {
    private static SessionFactory sessionFactory;


    public Product findById(Long id) {
        Session session = null;
        Transaction tr = null;
        Product product = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            Query query = session.createNativeQuery("SELECT * FROM Product where id = ?", Product.class);
            query.setParameter(1, id);

            product = (Product) query.getSingleResult();
            tr.commit();

        } catch (HibernateError e) {
            System.err.println("Error");
            System.err.println(e.getMessage());
        } finally {
            if (session != null)
                session.close();

        }
        return product;
    }

        public List<Product> findByName(String name){
            Session session = null;
            Transaction tr = null;
            List<Product> products = null;
            try {
                session = createSessionFactory().openSession();
                tr = session.getTransaction();
                tr.begin();

                Query query = session.createNativeQuery("SELECT * FROM Product where name = ?",Product.class );
                query.setParameter(1, name);


                tr.commit();
                products =  query.list();
            } catch (HibernateError e){
                System.err.println("Error");
                System.err.println(e.getMessage());


            }finally {
                if (session != null)
                    session.close();

            }
            return products;
    }

    public List<Product> findByContainedName(String name){
        Session session = null;
        Transaction tr = null;
        List<Product> products = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();


            Query query = session.createNativeQuery("SELECT * FROM Product where name like ?", Product.class);
            query.setParameter(1,  "%" + name + "%");

            tr.commit();
            products =  query.list();

        } catch (HibernateError e){
            System.err.println("Error");
            System.err.println(e.getMessage());

        }finally {
            if (session != null)
                session.close();

        }
        return products;
    }

    public List<Product> findByPrice(int price, int delta){
        Session session = null;
        Transaction tr = null;
        List<Product> products = null;
        double min = price - delta;
        double max = price + delta;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();


            Query query = session.createNativeQuery("SELECT * FROM Product where price between ? and ?", Product.class);
            query.setParameter(1,  min);
            query.setParameter(2,  max);


            tr.commit();
            products =  query.list();
        } catch (HibernateError e){
            System.err.println("Error");
            System.err.println(e.getMessage());

        }finally {
            if (session != null)
                session.close();

        }
        return products;
    }

    public List<Product> findBySortedAsc(String name){
        Session session = null;
        Transaction tr = null;
        List<Product> products = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            Query query = session.createNativeQuery("SELECT * FROM Product where name = ? ORDER BY name asc", Product.class);
            query.setParameter(1, name);


            tr.commit();
            products =  query.list();
        } catch (HibernateError e){
            System.err.println("Error");
            System.err.println(e.getMessage());

        }finally {
            if (session != null)
                session.close();

        }
        return products;
    }

    public List<Product> findBySortedDesc(String name){
        Session session = null;
        Transaction tr = null;
        List<Product> products = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            Query query = session.createNativeQuery("SELECT * FROM Product where name = ? ORDER BY name desc ", Product.class);
            query.setParameter(1, name);


            tr.commit();
            products =  query.list();
        } catch (HibernateError e){
            System.err.println("Error");
            System.err.println(e.getMessage());

        }finally {
            if (session != null)
                session.close();

        }
        return products;
    }

    public List<Product> findByPriceSortedDesc(int price, int delta){
        Session session = null;
        Transaction tr = null;
        List<Product> products = null;
        double min = price - delta;
        double max = price + delta;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();


            Query query = session.createNativeQuery("SELECT * FROM Product where price between ? and ? order by price desc ", Product.class);
            query.setParameter(1,  min);
            query.setParameter(2,  max);


            tr.commit();
            products =  query.list();
        } catch (HibernateError e){
            System.err.println("Save is failed");
            System.err.println(e.getMessage());

        }finally {
            if (session != null)
                session.close();

        }
        return products;
    }


    public static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory =  new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
