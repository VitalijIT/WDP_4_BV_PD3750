package zad1;

import java.lang.reflect.Array;

public class StringTransformer {
    public String[] transformStringToArray(String str) {
        return str.split("[,;.\\s]+");
    }
}
