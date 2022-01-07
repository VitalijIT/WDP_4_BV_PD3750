package zad3;

import zad3.Flowers.Flower;

import java.util.List;

public class Customer {

    private final String name;
    private double wallet;
    private final ShoppingCart shoppingCart;

    public Customer(String name, double wallet) {
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ShoppingCart(this);
    }

    public void get(Flower flower) {
        this.shoppingCart.addToShoppingCart(flower);
    }

    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }

    public void pay() {
        List<Flower> flowers = shoppingCart.getShoppingCart();

        for (Flower flower : flowers) {
            Double flowerCost = shoppingCart.getCost(flower);

            if (flowerCost != null && wallet >= flowerCost) {
                wallet -= flowerCost;
            } else {
                shoppingCart.deleteFromShoppingCart(flower.getName());
            }
        }
    }

    public double getCash() {
        return this.wallet;
    }

    public void pack(Box box) {
        box.pack(shoppingCart.getShoppingCart());
        shoppingCart.empty();
    }

    public String getName() {
        return name;
    }
}
