package frompythontojava.onlineshop.part2;

public class CheckoutProcess extends AbstractProcess{

    @Override
    protected void action(Orderable item){
        item.checkout();
        System.out.println("Checkout done.");
    }
}
