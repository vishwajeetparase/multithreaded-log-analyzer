/**
 * This interface defines a contract for filtering log entries based on some criteria.
 * (Optional if you only need basic filtering)
 */
public interface LogEntryFilter {

    /**
     * Checks if a log entry satisfies the filtering criteria.
     * 
     * @param logEntry The log entry to be evaluated.
     * @return true if the entry passes the filter, false otherwise.
     */
    boolean accept(LogEntry logEntry);
  }
  