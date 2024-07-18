/**
 * This interface defines the contract for processing parsed log entries. It outlines the core functionality
 * expected from any processor responsible for handling log data.
 */
public interface LogProcessor {

    /**
     * Processes a single log entry. This method takes a `LogEntry` object as input and performs
     * the specific processing logic defined by the implementing class.
     * 
     * @param logEntry The log entry object containing the parsed data.
     */
    void process(LogEntry logEntry);
  }
  