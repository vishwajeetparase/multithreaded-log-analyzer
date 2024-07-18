/**
 * This class represents a single log entry parsed from a log file.
 * It defines the basic properties commonly found in log data.
 */
public class LogEntry {

    private String timestamp;
    private String message;
    private LogLevel level;
  
    // Getters and Setters for each property (omitted for brevity)
  
    public LogEntry(String timestamp, String message, LogLevel level) {
      this.timestamp = timestamp;
      this.message = message;
      this.level = level;
    }
  
    // Additional methods specific to log data processing (optional)
  }
  
  /**
   * An enum representing different log message levels (e.g., INFO, WARNING, ERROR).
   */
  public enum LogLevel {
    INFO,
    WARNING,
    ERROR,
    // ... (Add additional levels if needed)
  }
  