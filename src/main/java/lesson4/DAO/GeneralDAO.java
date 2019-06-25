package lesson4.DAO;

import lesson4.exception.InternalServerException;
import lesson4.exception.UserNotFoundException;
import lesson4.model.IdEntity;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class GeneralDAO<T extends IdEntity> {

    public GeneralDAO(Class<T> type) {
        this.type = type;
    }

    private static SessionFactory sessionFactory;

    abstract Class aClass();

    public Transaction tr = null;

    private Class<T> type;


    public T save(T t) throws InternalServerException {
        try (Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            session.save(t);



            tr.commit();

            System.out.println("Save is done");
        } catch (HibernateError e) {
            throw new InternalServerException("Save is failed");
        }
        return t;
    }

    public void delete(Long id) throws InternalServerException {
        try (Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            session.delete(session.get(aClass(), id));

            tr.commit();

            System.out.println("Delete is done");
        } catch (HibernateError e) {
            throw new InternalServerException("Delete is failed");
        }
    }

    public T update(T t) throws InternalServerException {
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();

            session.update(t);

            tr.commit();

            System.out.println("Update is done");
        } catch (HibernateError e) {
            throw new InternalServerException("Update is failed");

        }
        return t;
    }

    public T findById(Long id, Class cl) throws UserNotFoundException, InternalServerException {
        type = cl;
        T t;

        try {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();


            t = session.get(type, id);

            tr.commit();

        } catch (HibernateError e) {
            throw new InternalServerException("Search is failed");
        }
        if (t == null)
            throw new UserNotFoundException("Object with id " + id + " not found");
        return t;
    }


    static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}
