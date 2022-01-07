package zad3.Flowers;

public abstract class Flower {

    private final int amount;
    private final String color;
    private final String name;

    public Flower(int amount, String name, String color) {
        this.amount = amount;
        this.name = name;
        this.color = color;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", kolor: " + color + ", ilość " + amount;
    }
}
