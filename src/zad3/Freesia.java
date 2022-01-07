package zad3;

public class Freesia extends Flower{
  protected String color = "żółty";
  protected final String name = "frezja";
  public Freesia(int amount) {
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
