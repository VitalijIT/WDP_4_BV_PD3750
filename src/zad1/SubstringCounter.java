package zad1;

public class SubstringCounter {
    public int countSubstrings(String str, String subStr) {

        int lastSubStrIndex = 0;
        int count = 0;

        while (lastSubStrIndex != -1) {

            lastSubStrIndex = str.indexOf(subStr, lastSubStrIndex);

            if (lastSubStrIndex != -1) {
                count++;
                lastSubStrIndex += subStr.length();
            }
        }

        return count;
    }
}
