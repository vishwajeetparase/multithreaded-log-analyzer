package com.skillup.processors;

import java.util.HashMap;
import java.util.Map;

import com.skillup.model.LogEntry;

/**
 * This class implements the LogProcessor interface to collect and aggregate statistics from log entries.
 * It keeps track of counts and other metrics for different log levels, messages, or other data points.
 */
public class StatisticsProcessor implements LogProcessor {

    private long infoCount;
    private long warningCount;
    private long errorCount;
    private Map<String, Long> messageCounts; // Track message occurrences
  
    public StatisticsProcessor() {
      this.infoCount = 0;
      this.warningCount = 0;
      this.errorCount = 0;
      this.messageCounts = new HashMap<>();
    }
  
    @Override
    public void process(LogEntry logEntry) {
      switch (logEntry.getLevel()) {
        case INFO:
          infoCount++;
          break;
        case WARNING:
          warningCount++;
          break;
        case ERROR:
          errorCount++;
          break;
      }
      String message = logEntry.getMessage();
      messageCounts.put(message, messageCounts.getOrDefault(message, 0L) + 1);
    }
  
    // Getter methods for accessing collected statistics (infoCount, warningCount, errorCount, messageCounts)
  }
  