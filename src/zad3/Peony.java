package zad3;

public class Peony extends Flower {
  protected String color = "niebieskawofioletowy";
  protected final String name = "piwonia";
  public Peony(int amount) {
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
