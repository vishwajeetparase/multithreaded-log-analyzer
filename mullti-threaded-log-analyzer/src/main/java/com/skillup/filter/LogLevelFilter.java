public class LogLevelFilter implements LogEntryFilter {

    private final LogLevel minLevel;
  
    public LogLevelFilter(LogLevel minLevel) {
      this.minLevel = minLevel;
    }
  
    @Override
    public boolean accept(LogEntry logEntry) {
      return logEntry.getLevel().compareTo(minLevel) >= 0;
    }
  }
  