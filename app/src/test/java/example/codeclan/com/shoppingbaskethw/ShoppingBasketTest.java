package example.codeclan.com.shoppingbaskethw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 21/07/2017.
 */

public class ShoppingBasketTest {

    private ShoppingBasket basket;
    private Customer customer;
    private Checkout checkout;
    private Product cheese;
    private Product bread;
    private Product potato;


    @Before
    public void setUp() throws Exception {
        basket = new ShoppingBasket();
        customer = new Customer(true, basket);
        checkout = new Checkout(basket, customer);
        cheese = new Product("Cheese", 3, true);
        bread = new Product("Bread", 5, true);
        potato = new Product("Potato", 1);
    }


    @Test
    public void testEmptyBasketAtStart() throws Exception {
        assertEquals(0, customer.countBasketSize());
    }

    @Test
    public void testAddItemToBasket() throws Exception {
        customer.putInBasket(cheese);
        assertEquals(1, customer.countBasketSize());
    }

    @Test
    public void testRemoveFromBasket() throws Exception {
        customer.putInBasket(cheese);
        customer.removeFromBasket("Cheese");
        assertEquals(0, customer.countBasketSize());
    }

    @Test
    public void testEmptyBasket() throws Exception {
        customer.putInBasket(cheese);
        customer.putInBasket(bread);
        assertEquals(2, customer.countBasketSize());
        customer.emptyBasket();
        assertEquals(0, customer.countBasketSize());
    }

    @Test
    public void checkBogofItems() throws Exception {
        customer.setNotLoyal();
        customer.putInBasket(cheese);
        customer.putInBasket(cheese);
        customer.putInBasket(bread);
        customer.putInBasket(bread);
        customer.putInBasket(potato);
        customer.putInBasket(potato);
        assertEquals(10, checkout.getFinalTotal());
    }

    @Test
    public void test20PercentOff() throws Exception {
        customer.setNotLoyal();
        Product tv = new Product("TV", 100);
        customer.putInBasket(tv);
        assertEquals(90, checkout.getFinalTotal());
    }

    @Test
    public void testLoyaltyCard() throws Exception {
        Product tv = new Product("TV", 100);
        customer.putInBasket(tv);
        assertEquals(88, checkout.getFinalTotal());
    }

    @Test
    public void testLargeTotal() throws Exception {
//        test bogof, 10% off and loyalty discounts
        Product tv = new Product("TV", 1349, true);
        customer.putInBasket(tv);
        customer.putInBasket(tv);
        assertEquals(1190, checkout.getFinalTotal());
    }
}
