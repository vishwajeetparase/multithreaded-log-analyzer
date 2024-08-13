package com.skillup.readers;

import java.io.BufferedReader;
import java.io.IOException;

import com.skillup.model.LogEntry;
import com.skillup.parsers.LogParser;

/**
 * This class implements the LogReader interface to read log data from a text file line by line.
 * It assumes each line represents a single log entry and parses it using a provided LogParser.
 */
public class FileReader implements LogReader {

    private final String filePath;
    private final LogParser parser;
  
    public FileReader(String filePath, LogParser parser) {
      this.filePath = filePath;
      this.parser = parser;
    }
  
    @Override
  public Iterable<LogEntry> readEntries() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        LogEntry logEntry = parser.parseLogEntry(line); // Parse line and create LogEntry object
        return logEntry; // Return the parsed LogEntry object
      }
    }
    return null; // Indicate the end of entries (optional)
  }
}
