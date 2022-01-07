package zad3;

import zad3.Flowers.Flower;

import java.util.ArrayList;
import java.util.List;

public class Box {

    private final Customer owner;
    private final List<Flower> box = new ArrayList<>();
    private final PriceList pl = PriceList.getInstance();

    public Box(Customer customer) {
        this.owner = customer;
    }

    public int getFlowersCostByColor(String color) {
        if (color != null && !box.isEmpty()) {
            return box.stream()
                    .filter(flower -> flower.getColor().equals(color))
                    .map(flower -> (int) (flower.getAmount() * pl.getPrice(flower.getName())))
                    .mapToInt(Integer::intValue)
                    .sum();
        }
        return -1;
    }

    public void pack(List<Flower> flowers) {
        box.addAll(flowers);
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("Pudełko własciciel " + owner.getName());
        if (box.isEmpty()) {
            return text + " -- pusto";
        }

        for (Flower flowerInCart : box) {
            String flowerString = flowerInCart.toString() + ", cena " + pl.getPrice(flowerInCart.getName());
            text.append(System.lineSeparator()).append(flowerString);
        }

        return text.toString();
    }
}
