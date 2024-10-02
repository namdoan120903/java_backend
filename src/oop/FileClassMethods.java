package oop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileClassMethods {
  public static void main(String[] args) throws IOException {
    FileInputStream inputStream = null;
    FileOutputStream outputStream = null;

    try{
      inputStream = new FileInputStream("input.txt");
      outputStream = new FileOutputStream("output.txt");

      int c;
      while ((c = inputStream.read()) != -1) {
        outputStream.write((char)c);
      }
    }finally {
      inputStream.close();
      outputStream.close();
    }
  }
}
