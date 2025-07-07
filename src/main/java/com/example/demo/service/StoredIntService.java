package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class StoredIntService {

  private static final String filePath = "/tmp/stored-int";

  public int getOrCreatedStoredInt() {
    try {
      Path path = Paths.get(filePath);
      String value;

      if (Files.exists(path)) {
        value = Files.readString(path).trim();
      } else {
        int randomInt = new Random().nextInt(100) + 1;
        value = String.valueOf(randomInt);
        Files.writeString(path, value);
      }
      return Integer.parseInt(value);
    } catch (IOException e) {
      System.err.println("Erreur d'accès au fichier : " + e.getMessage());
      throw new RuntimeException("Erreur lors de l'accès au fichier stored-int.txt", e);
    }
  }
}
