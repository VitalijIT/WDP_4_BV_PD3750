package zad3;

import java.util.List;
import java.util.Objects;

public class Customer {
  private String name;
  private double wallet;
  private final ShoppingCart shoppingCart;
  private Box box;

  public Customer (String name, double wallet) {
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

    for(int i = 0; i < flowers.size(); i++) {
      Flower flower = flowers.get(i);
      Double flowerCost = shoppingCart.getCost(flower);

      if( flowerCost != null && wallet >= flowerCost) {
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
    this.box = box;

    box.pack(shoppingCart.getShoppingCart());
    shoppingCart.empty();
  }

  public String getName() {
    return name;
  }
}
