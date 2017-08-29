package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class ProductCategory{
    private String name;
    protected static Integer counter = 1;
    private Integer ID;
    protected static ArrayList<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();

    public ProductCategory(){
    }

    public ProductCategory(String name){
        this.name = name;
        this.ID = counter;
        counter++;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "ID:" + this.ID + ",name:" + this.getName();
    }

    public static ArrayList<ProductCategory> getCategoryList(){

        return productCategoryList;
    }

}
