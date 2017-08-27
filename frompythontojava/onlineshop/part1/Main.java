import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Product japko, gruszka, banan, kiwi, ziemniak, cola, kurczak;
        ProductCategory warzywa = new FeaturedProductCategory("warzywa", new Date(2018,02,15));
        ProductCategory owoce = new ProductCategory("owoce");
        ProductCategory picie = new ProductCategory("picie");
        ProductCategory nabiał = new ProductCategory("nabiał");

	    japko = new Product("jabłko", 2.5f, owoce);
        gruszka = new Product("gruszka", 3.5f, owoce);
	    banan = new Product("banan", 4.5f, warzywa);
	    kiwi = new Product("kiwi", 1.5f, owoce);
	    ziemniak = new Product("ziemniak", 0.5f, warzywa);
	    cola = new Product("cola", 0.5f, picie);
	    kurczak = new Product("kurczak", 0.5f, nabiał);

        Basket koszyk = new Basket();
        koszyk.addProduct(japko);
        koszyk.addProduct(gruszka);
        koszyk.addProduct(banan);
        koszyk.addProduct(kiwi);
        koszyk.addProduct(ziemniak);
        koszyk.addProduct(cola);
        koszyk.addProduct(kurczak);
        koszyk.removeProduct(banan);

        koszyk.showProducts();

    }
}
