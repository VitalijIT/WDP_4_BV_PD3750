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

    String str = args[0];
    String findStr = args[1];
    int strLength = str.length();

    System.out.println(strLength);

    System.out.println(str.charAt(0) + " " + str.charAt(strLength - 1));

    System.out.println(str.substring(4));

    System.out.println(str.substring(4, strLength - 1));

    SubstringCounter sCounter = new SubstringCounter();
    System.out.println(sCounter.countSubstrings(str, findStr));

    StringTransformer strTransformer = new StringTransformer();
    String[] strArr = strTransformer.transformStringToArray(str);
    System.out.println(String.join("_", strArr));

    System.out.println(strArr[0].equals(strArr[strArr.length - 1]));

  }

  static void syntax() {
    System.out.println("Syntax: ... ");
    System.exit(1);
  }
}
