import java.util.ArrayList;
import java.util.Iterator;

public class Basket{
    private ArrayList<Product> productList = new ArrayList<Product>();
    private Iterator iterator;

    public Iterator getIterator(){
        return new ProductIterator();
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public Boolean removeProduct(Product product){
        for(iterator = getIterator(); iterator.hasNext();){
            if(product.equals(iterator.next())){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public void showProducts(){
        for(iterator = getIterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
