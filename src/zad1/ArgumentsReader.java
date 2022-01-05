package zad1;

import java.util.Scanner;

public class ArgumentsReader {
    public String readString(String request) {
        Scanner scan = new Scanner(System.in);
        if (request != null && request.length() > 0) System.out.println(request);
        String name = scan.next();
        return name;
    }
}
