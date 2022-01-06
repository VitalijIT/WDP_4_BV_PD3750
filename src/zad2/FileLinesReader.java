package zad2;

import java.io.BufferedReader;
import java.io.IOException;

class FileLinesReader {
  public static String readFile(String fileName) throws IOException {
    String text = "";
    String line;

    try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
      while ((line = br.readLine()) != null) {

        text = line + " " + br.readLine();
      }
    }

    return text;
  }
}
