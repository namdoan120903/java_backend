package oop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileClassMethods {
  public static void listFile(String path){
    File directory = new File(path);
    if (directory.isDirectory()) {
      File[] files = directory.listFiles();
      for (File file : files) {
        System.out.println("File: " + file.getName());
      }
    } else {
      System.out.println(path +" is not directory");
    }
  }
  public static void readFile(String path){
    try{
      String content = new String(Files.readAllBytes(Paths.get(path)));
      System.out.println(content);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  public static void main(String[] args) {

  }
}
