public class Order implements Orderable{
    private int id;
    private String status;
    private static int counter;

    public Order(){
        this.status = "new";
    }

    public String getStatus(){
        return this.status;
    }

    
}
