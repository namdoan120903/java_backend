package oop;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteCharacter {

  public static void main(String[] args) throws IOException {
    FileReader input = null;
    FileWriter output = null;

    try{
      input = new FileReader("input.txt");
      output = new FileWriter("output.txt");
      int c;
      while((c = input.read()) != -1){
        output.write((c));
      }
      System.out.println("write successful");
    }finally {
      input.close();
      output.close();
    }
  }
}
