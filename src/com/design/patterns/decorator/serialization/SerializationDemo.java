package com.design.patterns.decorator.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

  public static void main(String[] args) {
    Cat purr = new Cat("Purr", 3);

    // Decorating FileOutputStream with ObjectOutputStream
    try(FileOutputStream fos = new FileOutputStream("serialized.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {  // Try with resources.
      oos.writeObject(purr);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    try(FileInputStream fis = new FileInputStream("serialized.txt");
        ObjectInputStream ois = new ObjectInputStream(fis)) {
      purr = (Cat) ois.readObject();
      System.out.println("Deserialized: " + purr.getName() + " " + purr.getAge());
    } catch (IOException | ClassNotFoundException e) { // Multi-catch.
      e.printStackTrace();
    }
  }
}

/*
 * NOTES:
 * 
 * We decorated FileOutputStream and FileInputStream with ObjectOutputStream & ObjectInputStream respectively
 * to leverage different behaviors without altering any existing code. This is an example of decorator pattern.
 * 
 * File*Stream = provides low level file reading/writing capabilities but lacks serialization support.
 * Object*Stream = provides serialization capabilities but doesn't support file read/write.
 * 
 */
