package com.skillup.parsers;

/**
 * This class implements the Factory Pattern to create concrete LogParser objects based on the provided log format.
 * It allows for easy creation of the appropriate parser based on the log file format.
 */
public class LogParserFactory {

    /**
     * Creates a concrete LogParser object based on the specified format. This method takes a string representing
     * the format of the log file (e.g., JSON, Text, etc.) and returns a corresponding concrete implementation
     * of the `LogParser` interface.
     *
     * @param format The format of the log file (e.g., JSON, Text).
     * @return A concrete LogParser instance for the specified format.
     * @throws IllegalArgumentException If the provided format is not supported.
     */
    public static LogParser createParser(String format) throws IllegalArgumentException {
      switch (format.toUpperCase()) {
        case "JSON":
          return new JsonLogParser();
        case "TEXT":
          // return new TextLogParser();
        // Add additional cases for other supported formats (e.g., XML)
        default:
          throw new IllegalArgumentException("Unsupported log format: " + format);
      }
    }
  }
  