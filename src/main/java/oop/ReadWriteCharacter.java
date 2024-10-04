package oop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteCharacter {
  public static void readWriteText() throws IOException {
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

  public static void readWriteByte() throws IOException{
    FileInputStream inputStream = null;
    FileOutputStream outputStream = null;

    try{
      inputStream = new FileInputStream("input.txt");
      outputStream = new FileOutputStream("output.txt");

      byte[] data = new byte[inputStream.available()];
      outputStream.write(data);
    }catch (IOException e){
      e.printStackTrace();
    }
    finally {
      inputStream.close();
      outputStream.close();
    }
  }

  public static void main(String[] args) throws IOException {
    readWriteByte();
    readWriteText();
  }
}
