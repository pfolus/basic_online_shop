import java.util.ArrayList;

public class Product{
    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Integer ID;
    private static ArrayList<Product> productList = new ArrayList<Product>() ;
    private static Integer counter = 1;
