package lesson3.DAO;

import lesson3.Hotel;
import lesson3.IdEntity;
import lesson3.Room;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public abstract class GeneralDAO<T extends IdEntity> {
    private static SessionFactory sessionFactory;
    private Session session = null;
    private Transaction tr = null;


    abstract String getQuery();
    abstract Class aClass();

    public  T save(T t){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            session.save(t);

            tr.commit();

            System.out.println("Save is done");
        } catch (HibernateError e){
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }
        return t;
    }

    public void delete(Long id){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            T t = getObject(id, session);

            session.delete(t);

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

    public T update(T t){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            session.update(t);

            tr.commit();

            System.out.println("Update is done");
        } catch (HibernateError e){
            System.err.println("Update is failed");
            System.err.println(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }
        return t;
    }

    public T findById(Long id) {
        T t = null;

        try {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();


            t = (T) session.get(aClass(), id);

   //         t = getObject(id, session);

            tr.commit();

        } catch (HibernateError e) {
            System.err.println(e.getMessage());
//        }finally {
//            if (session != null)
//                session.close();
        }
        return t;
    }

    private  T getObject(Long id, Session session){
        T t;
        Query query = session.createQuery(getQuery());
        query.setParameter("id", id);

        return t = (T) query.getSingleResult();
    }



    private static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory =  new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
