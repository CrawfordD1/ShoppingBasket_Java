package example.codeclan.com.shoppingbaskethw;

import java.util.ArrayList;

/**
 * Created by user on 21/07/2017.
 */

public class ShoppingBasket {

    private ArrayList<Product> basket;
    private int basketValue;

    public ShoppingBasket() {
        this.basket = new ArrayList<>();
        this.basketValue = 0;
    }

    public ArrayList<Product> getBasket(){
        return this.basket;
    }

    public void addToBasket(Product item){
        basket.add(item);
        this.basketValue += item.getPrice();
    }

    public Product get(int index){
        return this.basket.get(index);
    }

    public int quantity(){
        return this.basket.size();
    }

    public void remove(int index){
        int price = this.basket.get(index).getPrice();
        this.basket.remove(index);
        this.basketValue -= price;
    }

    public int total() {
        return this.basketValue;
    }

    public void emptyBasket(){
        basket.clear();
    }
}
