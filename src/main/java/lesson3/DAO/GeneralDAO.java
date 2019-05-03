package lesson3.DAO;

import lesson3.IdEntity;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class GeneralDAO<T extends IdEntity> {
    private static SessionFactory sessionFactory;

    private Transaction tr = null;

    abstract Class aClass();

    public  T save(T t){
        try (Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            session.save(t);

            tr.commit();

            System.out.println("Save is done");
        } catch (HibernateError e){
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
        }
        return t;
    }

    public void delete(Long id){
        try (Session session = createSessionFactory().openSession())  {

            tr = session.getTransaction();
            tr.begin();

            T t;

            t = (T) session.get(aClass(), id);

            session.delete(t);

            tr.commit();

            System.out.println("Delete is done");
        } catch (HibernateError e){
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());
        }
    }

    public T update(T t){
        try (Session session = createSessionFactory().openSession())  {
            tr = session.getTransaction();
            tr.begin();

            session.update(t);

            tr.commit();

            System.out.println("Update is done");
        } catch (HibernateError e){
            System.err.println("Update is failed");
            System.err.println(e.getMessage());
        }
        return t;
    }

    public T findById(Long id) {
        T t = null;

        try  {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();


            t = (T) session.get(aClass(), id);
            tr.commit();

        } catch (HibernateError e) {
            System.err.println(e.getMessage());
        }
        return t;
    }


    private static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory =  new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
