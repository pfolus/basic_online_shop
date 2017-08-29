package frompythontojava.onlineshop.part2;

public class Main {

    public static void main(String[] args) {
        Order zamowienie1 = new Order();
        Order zamowienie2 = new Order();
        System.out.println("zamowienie1: " + zamowienie1.getStatus());
        System.out.println("zamowienie2: " + zamowienie2.getStatus());

        CheckoutProcess checkout = new CheckoutProcess();
        PaymentProcess payment = new PaymentProcess();
        checkout.process(zamowienie2);
        payment.process(zamowienie1);

        System.out.println("zamowienie1: " + zamowienie1.getStatus());
        System.out.println("zamowienie2: " + zamowienie2.getStatus());

    }
}
