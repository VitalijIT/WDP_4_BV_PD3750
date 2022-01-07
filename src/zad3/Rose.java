package zad3;

public class Rose extends Flower {
  private String color = "czerwony";
  private final String name = "róża";
  public Rose(int amount) {
    super(amount);
  }

  public String getName() {
    return name;
  };

  public String getColor() {
    return color;
  }

  @Override
  public String toString() {
    return name + ", kolor: " + color + ", ilość " + this.getAmount();
  }
}
