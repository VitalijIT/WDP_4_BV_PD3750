package zad3;

import java.util.ArrayList;
import java.util.List;

public class Box {
  Customer owner;
  List<Flower> box = new ArrayList<>();
  PriceList pl = PriceList.getInstance();

  public Box(Customer customer) {
    this.owner = customer;
  }

  public int getFlowersByColor(String color) {
    if (color != null && !box.isEmpty()) {
      for (int i = 0; i < box.size(); i++) {
        Flower flower = box.get(i);
        if(flower.getColor().equals(color)) {
          return (int) (flower.getAmount() * pl.getPrice(flower.getName()));
        }
      }
    }
    return -1;
  }

  public void pack(List<Flower> flowers) {
    box.addAll(flowers);
  }

  // TODO use from extended (abstract if it's possible) shoppingCart
  @Override
  public String toString() {
    StringBuilder text = new StringBuilder("Pudełko własciciel " + owner.getName());
    int cartSize = box.size();
    if (cartSize == 0) return text + " -- pusto";

    for(int i = 0; i < cartSize; i++) {
      Flower flowerInCart = box.get(i);
      String flowerString = flowerInCart.toString() + ", cena " + pl.getPrice(flowerInCart.getName());
      text.append(System.lineSeparator()).append(flowerString);
    }

    return text.toString();
  }
}
