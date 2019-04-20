package lesson2.homework.HQL;

public class Demo {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        System.out.println(productDAO.findById((long) 3));
        //System.out.println(productDAO.findByName("Table"));
        //System.out.println(productDAO.findByContainedName("car"));
        //System.out.println(productDAO.findByPrice(100, 50));

        //System.out.println(productDAO.findBySortedAsc("Table"));
        //System.out.println(productDAO.findBySortedDesc("Table"));
        //System.out.println(productDAO.findByPriceSortedDesc(300, 200));
    }
}
