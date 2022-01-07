package zad3;

import zad3.Flowers.Flower;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {

    private List<Flower> shoppingCart = new ArrayList<>();
    private final Customer owner;
    private final PriceList priceList = PriceList.getInstance();

    public ShoppingCart(Customer owner) {
        this.owner = owner;
    }

    public void addToShoppingCart(Flower flower) {
        this.shoppingCart.add(flower);
    }

    public void deleteFromShoppingCart(String flowerName) {
        shoppingCart = shoppingCart.stream()
                .filter(flower -> !flower.getName().equals(flowerName))
                .collect(Collectors.toList());
    }

    public List<Flower> getShoppingCart() {
        return shoppingCart;
    }

    public Double getCost(Flower flower) {
        double flowerPrice = priceList.getPrice(flower.getName());
        return flowerPrice == -1 ? null : flower.getAmount() * priceList.getPrice(flower.getName());
    }

    public void empty() {
        shoppingCart.clear();
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("Wózek własciciel " + owner.getName());

        if (shoppingCart.isEmpty()) {
            return text + " -- pusto";
        }

        for (Flower flowerInCart : shoppingCart) {
            String flowerString = flowerInCart.toString() + ", cena " + priceList.getPrice(flowerInCart.getName());
            text.append(System.lineSeparator()).append(flowerString);
        }

        return text.toString();
    }
}