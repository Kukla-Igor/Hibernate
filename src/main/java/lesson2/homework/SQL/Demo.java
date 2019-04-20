package lesson2.homework.SQL;

public class Demo {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        //System.out.println(productDAO.findById((long) 3));
        //System.out.println(productDAO.findByName("Table"));
        //System.out.println(productDAO.findByContainedName("car"));
        //System.out.println(productDAO.findByPrice(300, 200));

        //System.out.println(productDAO.findBySortedAsc("Table"));
        //System.out.println(productDAO.findBySortedDesc("Table"));
        System.out.println(productDAO.findByPriceSortedDesc(300, 200));
    }
}
