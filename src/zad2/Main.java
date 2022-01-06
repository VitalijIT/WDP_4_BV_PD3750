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
//      String line = "2007-01-12Jakis txt2008-01-31 xxx 2008-02-29 2008-15-10 2008-19-45 2009-05-01 \n" +
//              "20999-11-11 pppp 2001-00-01 09-01-01 2001-01-00 2009-01-111 2009-02-29 1998-11-11";
      String line = FileLinesReader.readFile(fname);

      if (line == null || line.isEmpty()) {
        throw new IllegalStateException();
      }

      StringTokenizer st = new StringTokenizer(line);

      List<String> data = new ArrayList<>();
      IsValidFormat dateValidator = new IsValidFormat();


      while (st.hasMoreTokens()) {
        String token = st.nextToken();
        token = token.replaceAll("[^\\d-]", "");
//        if (token.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) {
        if (dateValidator.isValidFormat("yyyy-MM-dd", token/*, Locale.ENGLISH*/)) {
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
