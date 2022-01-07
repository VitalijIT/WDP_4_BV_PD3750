package zad3;

import java.util.HashMap;
import java.util.Map;

public class PriceList {
  private static PriceList INSTANCE;

  private final Map<String, Double> priceList = new HashMap<>();

  private PriceList() {
  }

  public static PriceList getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new PriceList();
    }

    return INSTANCE;
  }

  public void put(String flowerName, double flowerPrice) {
      priceList.put( flowerName, flowerPrice );
  }

  public Double getPrice(String name) {
    return priceList.get(name) == null ? -1.0 : priceList.get(name);
  }

}
