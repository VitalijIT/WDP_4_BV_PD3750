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

    if (args.length < 2) syntax();

    String str = args[0]; // "ala ma kota, ale  ma psa.psa.hopsa. psa kota psa ma ala";
    String findStr = args[1]; // "sto";
    int strLength = str.length();

    System.out.println(strLength); // n1

    System.out.println(str.charAt(0) + " " + str.charAt(strLength - 1)); // n2

    System.out.println(str.substring(4)); // n3

    System.out.println(str.substring(4, strLength - 1)); // n4

    SubstringCounter sCounter = new SubstringCounter();
    System.out.println(sCounter.countSubstrings(str, findStr)); // n5

    StringTransformer strTransformer = new StringTransformer();
    String[] strArr = strTransformer.transformStringToArray(str);
    System.out.println(String.join("_", strArr)); // n6

    System.out.println(strArr[0].equals(strArr[strArr.length - 1])); // n7

  }

  static void syntax() {
    System.out.println("Syntax: ... ");
    System.exit(1);
  }
}
