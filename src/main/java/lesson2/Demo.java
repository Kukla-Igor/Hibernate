package lesson2;

import lesson1.Product;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();
        product.setName("Table new");
        product.setDescription("grey & blue update");
        product.setPrice(70);

        //productDAO.save(product);

        Product product1 = new Product();
        product1.setName("Table new111");
        product1.setDescription("grey & blue111");
        product1.setPrice(70);

        Product product2 = new Product();
        product2.setName("Table new222");
        product2.setDescription("grey & blue111");
        product2.setPrice(80);

        Product product3 = new Product();
        product3.setName("Table new333");
        product3.setDescription("grey & blue111");
        product3.setPrice(90);


        //productDAO.saveAll(products);

        product.setId(47);

        //productDAO.update(product);
        //productDAO.delete(product);

        product1.setId(45);
        product2.setId(49);
        product3.setId(51);
        List<Product> products = Arrays.asList(product1, product2, product3);

        //productDAO.updateAll(products);
        productDAO.deleteAll(products);


    }
}
