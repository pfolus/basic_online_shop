package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Product{
    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Integer ID;
    private static ArrayList<Product> productList = new ArrayList<Product>() ;
    private static Integer counter = 1;

    public Product(){
    }

    public Product(String name, Float defaultPrice, ProductCategory productCategory){
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.productCategory = productCategory;
        this.ID = counter;
        productList.add(this);
        counter++;
    }

    public String getName(){
        return this.name;
    }
    
    public Float getDefaultPrice(){
        return this.defaultPrice;
        }

    public String toString(){
        return "ID:" + this.ID + ",name:" + this.name + ",defaultprice:" + this.defaultPrice + ",productcategory:" + this.productCategory;
    }

    public static ArrayList<Product> getAllProducts(){
        return productList;
    }

    public static ArrayList<Product> getAllProductsBy(ProductCategory productCategory){
        ArrayList<Product> productListByCat = new ArrayList<Product>();

        for(Product item : productList){
            if(item.productCategory.equals(productCategory)){
                productListByCat.add(item);
            }
        }

        return productListByCat;
    }
}
