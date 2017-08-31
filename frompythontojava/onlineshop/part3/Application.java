package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.Basket;
import frompythontojava.onlineshop.part1.FeaturedProductCategory;
import frompythontojava.onlineshop.part1.Product;
import frompythontojava.onlineshop.part1.ProductCategory;
import frompythontojava.onlineshop.part2.CheckoutProcess;
import frompythontojava.onlineshop.part2.Order;
import frompythontojava.onlineshop.part2.PaymentProcess;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {

        Basket basket = new Basket();

        while (true) {

            showMenu();
            String answer = View.getInput();
            ArrayList<ProductCategory> categoryList = ProductCategory.getCategoryList();

            if (answer.equals("1")) {
                createProduct();

            } else if (answer.equals("2")) {
                createNewTypeCategory(categoryList);

            } else if (answer.equals("3")) {
                addProductToBasket(basket);

            } else if (answer.equals("4")) {
                displayAllBasketProducts(basket);

            } else if (answer.equals("5")) {
                removeProductFromBasket(basket);

            } else if (answer.equals("6")) {
                displayAllAvailableProducts();

            } else if (answer.equals("7")) {
                showProductsByCategory();

            } else if (answer.equals("8")) {
                productAvailability();

            } else if (answer.equals("9")) {
                acceptOrder(basket);
            }
        }
    }

    public static String createProductName(){
        View.provideProductName();
        String name = View.getInput();
        return name;
    }

    public static Float createProductPrice() {

        try {
            View.provideProductPrice();
            String strPrice = View.getInput();
            Float price = Float.valueOf(strPrice);
            return price;

        }catch(NumberFormatException e){
            View.showWrongPriceMsg();
            return null;
        }
    }
    public static ProductCategory createCategory() {
        ArrayList<ProductCategory> categoryList = ProductCategory.getCategoryList();

        displayCategories(categoryList);

        View.chooseCategoryName();
        String catName = View.getInput();

        ProductCategory category = new ProductCategory(catName);
        return category;

    }

    public static Product createProduct() {

        String name = createProductName();
        Float price = createProductPrice();
        ProductCategory category = createCategory();

        Product item = new Product(name, price, category);

        return item;

    }

    public static void createNewTypeCategory(ArrayList<ProductCategory> categoryList) {

        View.provideCategoryName();
        String catName = View.getInput();
        View.chooseCategoryType();
        String catType = View.getInput();

        if (catType.equals("YES")) {
            View.provideDate();
            String catDate = View.getDate();

            categoryList.add(FeaturedProductCategory.createCategory(catName, catDate));
        } else {
            categoryList.add(new ProductCategory(catName));
        }
    }


    public static ProductCategory findCategory(){
        String choice = View.getInput();
        ArrayList <ProductCategory> categoryList = ProductCategory.getCategoryList();
        for (ProductCategory category : categoryList) {
            if(category.getName().equals(choice)){
                return category;
            }
        }
        return null;
    }

    public static void showProductsByCategory() {
        ProductCategory category = findCategory();
        ArrayList productsByCat = Product.getAllProductsBy(category);
        displayProducts(productsByCat);
    }


    public static void addProductToBasket(Basket basket) {
        ArrayList<Product> ProductList;
        ProductList = getAllAvailableProducts();

        displayProducts(ProductList);

        View.provideNameProductToAdd();
        String name = View.getInput();

        for (Product item : ProductList) {
            if (item.getName().equals(name)) {
                basket.addProduct(item);
            }
        }
    }

    public static void displayAllBasketProducts(Basket basket) {
        basket.showProducts();
        }

    public static void removeProductFromBasket(Basket basket) {
        displayAllBasketProducts(basket);
        View.provideProductNameToDelete();
        String choice = View.getInput();

        ArrayList<Product> itemsToDelete = new ArrayList<>();

        for (Product product : basket.getProductList()) {
            if (choice.equals(product.getName())) {
                itemsToDelete.add(product);
            }
        }
        if (!itemsToDelete.isEmpty()) {
            for (Product product : itemsToDelete) {
                basket.removeProduct(product);
            }
        }else{
            View.showEmptyBasketMsg();
        }
    }

    public static ArrayList<Product> getAllAvailableProducts() {
        if (!Product.getAllProducts().isEmpty()) {
            return Product.getAllProducts();
        } else {
            return null;
        }
    }

    public static void displayAllAvailableProducts() {
        ArrayList products = getAllAvailableProducts();
        displayProducts(products);
    }


    public static void productAvailability() {
        System.out.println("type product you want to check: ");
        String getProduct = View.getInput();
        ArrayList<Product> allAvailableProducts = new ArrayList<>();
        ArrayList<Product> allProducts = getAllAvailableProducts();

        for (Product product : allProducts) {
            if(product.getName().equals(getProduct)) {
                allAvailableProducts.add(product);
            }
        }
        displayProducts(allAvailableProducts);

    }

    public static void displayProducts(ArrayList array) {

        try{
            for (Object item : array) {
                System.out.println(item);
            }
        }catch (NullPointerException n){
            View.showNoAddedProductsMsg();
        }
    }

    public static void displayCategories(ArrayList<ProductCategory> categoriesList) {

        if (!categoriesList.isEmpty()) {
            View.showAvaiableCategoriesMsg();

            for (ProductCategory item : categoriesList) {
                System.out.println(item.getName());
            }
         }else{
            View.showEmptyCategoriesListMsg();
         }
    }

    public static Order createOrder(Basket basket) {
        displayProducts(basket.getProductList());
        View.showTotalPriceInfo(basket);

        Order order = new Order();

        return order;
    }

    public static void acceptOrder(Basket basket){
        Order order = createOrder(basket);
        confirmOrderDetails(order);
        confirmToPayForOrder(order, basket);
    }


    public static void confirmOrderDetails(Order order) {
        View.acceptOrderMsg();
        String answer = View.getInput();
        if (answer.equals("YES")) {
            checkOrderProcess(order);
        }
    }

    public static void confirmToPayForOrder(Order order, Basket basket){
        View.confirmPaymentMsg();
        String answer2 = View.getInput();

        if (answer2.equals("YES")) {
            payOrderProcess(order);
            View.showOrderInfo(order);
            basket.clearBasket();
        }else{
            View.orderCanceledMsg();
        }
    }

    public static void checkOrderProcess(Order order) {
        CheckoutProcess checkProcess = new CheckoutProcess();
        checkProcess.process(order);
    }

    public static void payOrderProcess(Order order){
        PaymentProcess payProcess = new PaymentProcess();
        payProcess.process(order);
    }

    public static void showMenu() {
        View.printMenu();
    }
}
