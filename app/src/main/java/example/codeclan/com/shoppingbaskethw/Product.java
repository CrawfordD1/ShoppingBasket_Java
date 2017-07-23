package example.codeclan.com.shoppingbaskethw;

/**
 * Created by user on 21/07/2017.
 */

class Product {

    private String name;
    private int price;
    private boolean bogof;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, int price, boolean bogof){
        this.name = name;
        this.price = price;
        this.bogof = bogof;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBogof(){
        return this.bogof;
    }
}
