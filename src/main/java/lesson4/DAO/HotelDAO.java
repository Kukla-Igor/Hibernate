package lesson4.DAO;

import lesson4.exception.UserNotFoundException;
import lesson4.model.Hotel;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;


public class HotelDAO extends GeneralDAO {

    GeneralDAO generalDAO;

    public Hotel findHotelByName(String name) throws UserNotFoundException {

        Hotel hotel = null;

        try {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            Query query = session.createNativeQuery("SELECT * FROM Hotel where name = ?", Hotel.class);
            query.setParameter(1, name);
            hotel = (Hotel) query.getSingleResult();

            tr.commit();

        } catch (HibernateError e) {
            System.err.println(e.getMessage());
        } catch (NoResultException e) {
            throw new UserNotFoundException("Hotel is not found");
        }

        return hotel;
    }

    public Hotel findHotelByCity(String city) throws Exception {

        Hotel hotel = null;

        try {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            Query query = session.createNativeQuery("SELECT * FROM HOTEL where CITY = ?", Hotel.class);
            query.setParameter(1, city);
            hotel = (Hotel) query.getSingleResult();

            tr.commit();

        } catch (HibernateError e) {
            System.err.println(e.getMessage());
        } catch (NoResultException e) {
            throw new UserNotFoundException("Hotel is not found");
        }
        return hotel;
    }

    @Override
    Class aClass() {
        return Hotel.class;
    }
}