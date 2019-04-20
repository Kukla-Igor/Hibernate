package lesson2.homework.HQL;

import lesson1.Product;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

            Query query = session.createQuery("FROM Product where id = :id");
            query.setParameter("id", id);

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

                Query query = session.createQuery("FROM Product where name = :name");
                query.setParameter("name", name);

                products =  query.list();
                tr.commit();

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

            String hql = "FROM Product where name like :name";
            Query query = session.createQuery(hql);
            query.setParameter("name",  "%" + name + "%");

            products =  query.list();
            tr.commit();


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


            Query query = session.createQuery("FROM Product where price between :min and :max");
            query.setParameter("min",  min);
            query.setParameter("max",  max);

            products =  query.list();
            tr.commit();

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

            Query query = session.createQuery("FROM Product where name = :name ORDER BY name asc ");
            query.setParameter("name", name);

            products =  query.list();
            tr.commit();

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

            Query query = session.createQuery("FROM Product where name = :name ORDER BY name desc ");
            query.setParameter("name", name);

            products =  query.list();
            tr.commit();

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


            Query query = session.createQuery("FROM Product where price between :min and :max order by price desc ");
            query.setParameter("min",  min);
            query.setParameter("max",  max);

            products =  query.list();
            tr.commit();

        } catch (HibernateError e){
            System.err.println("Error");
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
