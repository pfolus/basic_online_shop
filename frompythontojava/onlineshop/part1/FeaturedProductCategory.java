import java.util.Date;

public class FeaturedProductCategory extends ProductCategory{
    private Date expirationDate;
    private Integer ID;
    private static Integer counter = 1;

    public FeaturedProductCategory(String name, Date expirationDate){
        super(name);
        this.expirationDate = expirationDate;
        this.ID = counter;
        counter++;
    }


    public String toString(){
        return this.getClass().getName() + ":ID:" + this.ID + ",name:" + this.getName();
    }
}
