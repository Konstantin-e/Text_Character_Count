package c2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BarChart {

private char[] alphabet = new char[26];
private int totalChars = 0;

  public void readFile(String fileName) {
    for (int i = 0; i < alphabet.length; i++) {
      alphabet[i] = 0;
    }
    try {
      File myFile = new File(fileName);
      Scanner myReader = new Scanner (myFile);
      while (myReader.hasNext()) {
        myReader.useDelimiter("");
        char c = myReader.next().toLowerCase().charAt(0);
        if (c >= 97 && c <= 122) {
          alphabet[c-97]++;
          totalChars++;
        }
        
      } 
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error");    
      e.printStackTrace();
    }
  }

  public void outStats() {
   double percent;
   System.out.println("Total # of characters: " + totalChars);
   for (int i = 0; i < alphabet.length; i++) {
      percent = 100.0 * alphabet[i] / totalChars;
      System.out.print((char)(i+97) + ": ");
    for (int j = 0; j < percent; j++) {
      System.out.print("█");
    }
    System.out.println(" -- " + String.format("%.2f", percent ) + "%");
  } 
  }
}
