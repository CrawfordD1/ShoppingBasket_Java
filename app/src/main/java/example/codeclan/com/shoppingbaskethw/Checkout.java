package example.codeclan.com.shoppingbaskethw;


/**
 * Created by user on 23/07/2017.
 */

public class Checkout {

    private int finalTotal;
    private ShoppingBasket basket;
    private Customer customer;


    public Checkout(ShoppingBasket basket, Customer customer) {
        this.basket = basket;
        this.customer = customer;
        this.finalTotal = 0;
    }

    public int getFinalTotal() {
        this.finalTotal = basket.total();
        checkBogof();
        checkTenPercent();
        checkLoyalty();
        return this.finalTotal;
    }

    private void checkBogof() {
        int discountAmount = 0;
        if (basket.getBasket() != null) {
            for (int i = 1; i< basket.quantity() + 1 ; i++){
                if ((i != 1) && (basket.get(i - 1).isBogof()) && (i % 2 == 0)){
                    discountAmount += basket.get(i - 1).getPrice();
                }
            }
        }
        this.finalTotal -= discountAmount;
    }

    private void checkTenPercent() {
        double percent = 0.10;
        long result = 0;
        if (this.finalTotal > 20){
            result = Math.round((this.finalTotal * percent));
        }
        this.finalTotal -= result;
    }

    private void checkLoyalty(){
        double percent = 0.02;
        long result = 0;
        if(customer.isLoyal()){
            result = Math.round((this.finalTotal * percent));
        }
        this.finalTotal -= result;
    }


}
