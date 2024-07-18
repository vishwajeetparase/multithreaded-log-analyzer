/**
 * This class implements the LogParser interface specifically for parsing text-formatted log entries.
 * It assumes a specific format where each log line consists of three parts separated by spaces:
 * 1. Timestamp
 * 2. Log level (e.g., INFO, WARNING, ERROR)
 * 3. Message
 */
public class TextLogParser implements LogParser {

    private static final Pattern pattern = Pattern.compile("^(\\S+)\\s+(\\S+)\\s+(.*)");
  
    @Override
    public LogEntry parseLogEntry(String logLine) throws ParseException {
      Matcher matcher = pattern.matcher(logLine);
      if (!matcher.matches()) {
        throw new ParseException("Invalid text log format: " + logLine);
      }
      String timestamp = matcher.group(1);
      String level = matcher.group(2);
      String message = matcher.group(3);
      return new LogEntry(timestamp, message, LogLevel.valueOf(level));
    }
  }
  