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

    private class ProductIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {
           if(index < productList.size()){
              return true;
           }
           return false;
        }

        @Override
        public Object next() {
           if(this.hasNext()){
              return productList.get(index++);
           }
           return null;
       }

       @Override
       public void remove(){
           productList.remove(index - 1);
       }
    }
}
