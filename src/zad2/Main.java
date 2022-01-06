/**
 *
 *  @author Bodnar Vitali PD3750
 *
 */

package zad2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    String fname = System.getProperty("user.home") + "/daty.txt";

    try {
      String line = FileLinesReader.readFile(fname);

      if (line == null || line.isEmpty()) {
        throw new IllegalStateException();
      }

      StringTokenizer st = new StringTokenizer(line);

      List<String> data = new ArrayList<>();
      IsValidDateFormat dateValidator = new IsValidDateFormat();


      while (st.hasMoreTokens()) {
        String token = st.nextToken();
        token = token.replaceAll("[^\\d-]", "");
        if (dateValidator.isValidFormat("yyyy-MM-dd", token)) {
          data.add(token);
        }
      }

      String stringResult = data.stream()
              .map(String::valueOf)
              .collect(Collectors.joining(" "));

      System.out.println(stringResult);

    } catch (IllegalArgumentException e) {
      System.out.println("***");
    } catch (Exception e) {
      System.out.println("***");
    }
  }

}
