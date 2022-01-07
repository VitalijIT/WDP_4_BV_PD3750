package zad3;

public abstract class Flower {
  private int amount;
  private String color;
  private String name;

  public Flower (int amount, String name, String color) {
    this.amount = amount;
    this.name = name;
    this.color = color;
  }

  @Override
  public String toString() {
    return name + ", kolor: " + color + ", ilość " + amount;
  }

  public Integer getAmount() {
    return amount;
  }

  public String getName() {
    return name;
  }


  public String getColor() {
    return color;
  }

}
