package lesson4.DAO;

import lesson4.model.User;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDAO extends GeneralDAO {
    public boolean check(User user){
        try (Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();
            Query query = session.createNativeQuery("SELECT * FROM USERS where USER_NAME like ? and COUNTRY like ? and USER_TYPE like ?", User.class);
            query.setParameter(1,  user.getUserName());
            query.setParameter(2,  user.getCountry());
            query.setParameter(3,  user.getUserType());

            tr.commit();

            if (!query.getResultList().isEmpty())
                return false;


        } catch (HibernateError e){
            System.err.println("Error");
            System.err.println(e.getMessage());
        }
        return true;
    }

    @Override
    Class aClass() {
        return User.class;
    }
}