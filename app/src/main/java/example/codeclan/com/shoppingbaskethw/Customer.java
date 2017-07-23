package example.codeclan.com.shoppingbaskethw;

/**
 * Created by user on 21/07/2017.
 */

class Customer {

    private final ShoppingBasket basket;
    private boolean loyalty;

    public Customer(boolean loyalty, ShoppingBasket basket) {
        this.loyalty = loyalty;
        this.basket = basket;
    }

    public void putInBasket(Product item){
        this.basket.addToBasket(item);
    }

    public void removeFromBasket(String name){
            for(int i = 0; i<this.basket.quantity(); i++){
                if(basket.get(i).getName().equalsIgnoreCase(name)){
                    this.basket.remove(i);
                }
            }
    }

    public int countBasketSize(){
        return this.basket.quantity();
    }

    public void emptyBasket(){
        this.basket.emptyBasket();
    }

    public boolean isLoyal() {
        return loyalty;
    }

    public void setNotLoyal() {
        this.loyalty = false;
    }
}
