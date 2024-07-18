/**
 * This class implements the LogParser interface specifically for parsing JSON-formatted log entries.
 * It utilizes the Jackson ObjectMapper library for efficient JSON parsing.
 */
public class JsonLogParser implements LogParser {

    private final ObjectMapper objectMapper;
  
    public JsonLogParser() {
      this.objectMapper = new ObjectMapper(); // Use a JSON parsing library
    }
  
    @Override
    public LogEntry parseLogEntry(String logLine) throws ParseException {
      try {
        // Parse the JSON string using ObjectMapper
        Map<String, Object> data = objectMapper.readValue(logLine, Map.class);
        String timestamp = (String) data.get("timestamp");
        String level = (String) data.get("level");
        String message = (String) data.get("message");
        return new LogEntry(timestamp, message, LogLevel.valueOf(level));
      } catch (JsonProcessingException e) {
        throw new ParseException("Error parsing JSON log entry: " + e.getMessage());
      }
    }
  }
  