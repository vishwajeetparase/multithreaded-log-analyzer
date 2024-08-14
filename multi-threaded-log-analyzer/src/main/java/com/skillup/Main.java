package com.skillup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws Exception {
  
    String folderPath = "multi-threaded-log-analyzer/src/TestData";

    // Create a thread pool
    int numThreads = Runtime.getRuntime().availableProcessors(); //Use available processors
    // System.out.println(numThreads); // 4 core processor = 4 Threads
    ExecutorService executor = Executors.newFixedThreadPool(numThreads);

    // Get all files in the folder
    File folder = new File(folderPath);
    File[] files = folder.listFiles((dir, name) -> name.endsWith(".json") || name.endsWith(".txt") || name.endsWith(".xml"));

    if (files == null) {
      throw new FileNotFoundException("Folder not found or empty: " + folderPath);
    }else{
      for (File file : files) {
        System.out.println(file);
        executor.submit(() -> processFile(file));
    }
    }
    executor.shutdown();
  }

  private static void processFile(File file) {
    if(file.endsWith(".json")){
      JsonLogParser(file);
    }
    else if(file.endsWith(".xml")){
      XmlLogParser(file);
    }
    else if(file.endsWith(".txt")){
      TextLogParser(file);
    }
}
}
