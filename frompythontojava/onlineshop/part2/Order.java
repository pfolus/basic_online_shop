public class Order implements Orderable{
    private int id;
    private String status;
    private static int counter = 1;

    public Order(){
        this.status = "new";
        this.id = counter;
        counter++;
    }

    public String getStatus(){
        return this.status;
    }

    public Boolean checkout(){
        this.status = "checked";
    }

    public Boolean pay(){
        this.status = "payed";
    }
}
