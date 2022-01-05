/**
 *
 *  @author Bodnar Vitali PD3750
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
//    ConsoleReader reader = new ConsoleReader();
//    String str = reader.readString("Wprowadź text");
//    String findStr = reader.readString("Wprowadź podstring dla wyszukania");
    String str = "ala ma kota, ale  ma psa.psa.hopsa. psa kota psa ma ala";
    String findStr = "sto";
    int strLength = str.length();

    System.out.println(strLength); // n1

    System.out.println(str.charAt(0) + " " + str.charAt(strLength - 1)); // n2

    System.out.println(str.substring(4)); // n3

    System.out.println(str.substring(4, strLength - 1)); // n4

    str = "podstoleczne tramwaje mialy postoje po sto razy dziennie";
    SubstringCounter sCounter = new SubstringCounter();
    System.out.println(sCounter.countSubstrings(str, findStr)); // n5

    str = "ala ma kota, ale  ma psa.psa.hopsa. psa kota psa ma ala";

    StringTransformer strTransformer = new StringTransformer();
    String[] strArr = strTransformer.transformStringToArray(str);
    System.out.println(String.join("_", strArr)); // n6

    System.out.println(strArr[0].equals(strArr[strArr.length - 1])); // n7

  }
}
