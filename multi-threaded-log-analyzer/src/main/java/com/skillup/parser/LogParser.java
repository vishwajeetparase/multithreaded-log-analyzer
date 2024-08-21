
/**
 * This interface defines the contract for all log parsers. It specifies the required functionality
 * for parsing a single log entry from a log line (string representation).
 */
public interface LogParser {

    /**
     * Parses a single log entry from a log line (string representation). This method takes a string
     * representing a single log line and returns a `LogEntry` object containing the extracted data
     * from the log line.
     *
     * @param logLine The string representing a single log entry.
     * @return A parsed log object containing extracted data from the log line.
     * @throws ParseException If there's an error parsing the log line.
     */
    List<LogEntry> parseLogEntry(String logLine) throws ParseException;
  }
  