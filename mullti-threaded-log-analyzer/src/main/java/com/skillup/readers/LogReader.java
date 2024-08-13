package com.skillup.readers;

import java.io.IOException;

import com.skillup.model.LogEntry;

/**
 * This interface defines the contract for reading log data from various sources. It provides a way to
 * decouple the log reading logic from the core processing pipeline.
 */
public interface LogReader {

    /**
     * Reads log entries from a specific source and provides them for processing. This method iterates
     * through the log entries from the source and yields them one by one for further processing.
     * 
     * @return An iterable object that yields log entries (e.g., LogEntry objects) from the source.
     * @throws IOException If there's an error while reading from the source.
     */
    Iterable<LogEntry> readEntries() throws IOException;
  }
  