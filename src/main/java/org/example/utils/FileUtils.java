package org.example.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

  public static File checkFileExists(String path) {

    return new File(path);
  }

  public static String readFile(File file) {

    StringBuilder sb = new StringBuilder();

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String linea;

      while ((linea = br.readLine()) != null) {
        sb.append(linea);
      }
    } catch (IOException e) {
      System.err.format("IOException whilst reading: %s%n", e);
    }
    return sb.toString();
  }

  public static void writeFile(File file, String json) {

    try (FileWriter writer = new FileWriter(createNewPath(file))) {
      writer.write(json);
    } catch (IOException e) {
      System.err.format("IOException whilst writing: %s%n", e);
    }
  }

  private static String createNewPath(File file) {

    String oldName = file.getName();
    String extension = oldName.substring(oldName.lastIndexOf("."));
    String oldNameWithExtension = oldName.split(extension)[0];
    String newName = oldNameWithExtension + "-fixed" + extension;

    try {
      return file.getPath().split(oldName)[0] + newName;
    } catch (Exception e) {
      return newName;
    }
  }
}
