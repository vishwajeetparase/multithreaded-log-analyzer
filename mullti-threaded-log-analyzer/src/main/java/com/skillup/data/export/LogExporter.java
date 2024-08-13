package com.skillup.data.export;

 /**
 * This class provides functionalities for exporting parsed log data to a CSV file.
 * It utilizes the OpenCSV library for robust CSV handling.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;
import com.skillup.model.LogEntry;

public class LogExporter {

  /**
   * Exports a list of LogEntry objects to a CSV file specified by the provided path.
   * 
   * @param logEntries A list of LogEntry objects containing the data to be exported.
   * @param filePath The path to the desired output CSV file.
   * @throws IOException If there's an error while writing to the CSV file.
   */
  public static void exportToCsv(List<LogEntry> logEntries, String filePath) throws IOException {
    // Create a CSV writer with OpenCSV library
    FileWriter writer = new FileWriter(filePath);
    CSVWriter csvWriter = new CSVWriter(writer);

    // Write header row
    csvWriter.writeNext(new String[]{"Timestamp", "Message", "Level"}); // Add more headers if needed

    // Write log entries
    for (LogEntry entry : logEntries) {
      csvWriter.writeNext(new String[]{entry.getTimestamp(), entry.getMessage(), entry.getLevel().toString()});
    }

    csvWriter.close();
  }
}
