package frompythontojava.onlineshop.part2;

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

    public int getId(){
        return this.id;
    }

    public Boolean checkout(){
        if(!this.status.equals("checked")){
            this.status = "checked";
            return true;
        }
        return false;
    }

    public Boolean pay(){
        if(!this.status.equals("payed")){
            this.status = "payed";
            return true;
        }
    return false;
    }
}
