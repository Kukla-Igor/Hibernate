package lesson1;

import org.hibernate.Session;

public class Demo {
    public static void main(String[] args) {
        save();


    }

    static void save(){
        Session session = new HibernateUtils().createSessionFactory().openSession();
        session.getTransaction().begin();
        Product product = new Product();
        product.setId(998);
        product.setName("Table");
        product.setDescription("grey & blue");
        product.setPrice(70);
        session.save(product);

        session.getTransaction().commit();

        System.out.println("Done");

        session.close();

    }
}
