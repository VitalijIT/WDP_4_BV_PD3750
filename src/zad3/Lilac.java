package zad3;

public class Lilac extends Flower {
  protected String color = "biały";
  protected String name = "bez";
  public Lilac (int amount) {
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
