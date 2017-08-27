public class CheckoutProcess{

    @Override
    protected void CheckoutProcess(Orderable item){
        item.checkout();
        System.out.println("Checkout done.");
    }
}
