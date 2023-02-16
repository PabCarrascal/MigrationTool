package org.example;

import java.io.File;
import org.example.utils.FileUtils;

public class Main {

  public static void main(String[] args) {

    Migrator migrator = new Migrator();
    File jsonFile = new File(args[0]);
    String inputJson = FileUtils.readFile(jsonFile);
    FileUtils.writeFile(jsonFile, migrator.migrate(inputJson));
  }
}