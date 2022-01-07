package zad3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ShoppingCart {
  private List<Flower> shoppingCart = new ArrayList<>();
  private Customer owner;
  PriceList pl = PriceList.getInstance();

  public ShoppingCart (Customer owner) {
    this.owner = owner;
  }

  public void addToShoppingCart(Flower flower) { // todo add method to add roze to roze
    this.shoppingCart.add(flower);
  }

  public void deleteFromShoppingCart(String flowerName) {
    shoppingCart = shoppingCart.stream()
            .filter(a -> !Objects.equals(a.getName(), flowerName))
            .collect(Collectors.toList());
  }

  public List<Flower> getShoppingCart() {
    return shoppingCart;
  }

  @Override
  public String toString() {
    StringBuilder text = new StringBuilder("Wózek własciciel " + owner.getName());
    int cartSize = shoppingCart.size();
    if (cartSize == 0) return text + " -- pusto";

    for(int i = 0; i < cartSize; i++) {
      Flower flowerInCart = shoppingCart.get(i);
      String flowerString = flowerInCart.toString() + ", cena " + pl.getPrice(flowerInCart.getName());
      text.append(System.lineSeparator()).append(flowerString);
    }

    return text.toString();
  }

  public Double getCost(Flower flower) {
    double flowerPrice = pl.getPrice(flower.getName());
    return flowerPrice == -1 ? null : flower.getAmount() * pl.getPrice(flower.getName());
  }

  public void empty() {
    shoppingCart.clear();
  }
}