public class ProductCategory{
    private String name;
    protected static Integer counter = 1;
    private Integer ID;

    public ProductCategory(){
    }

    public ProductCategory(String name){
        this.name = name;
        this.ID = counter;
        counter++;
    }

