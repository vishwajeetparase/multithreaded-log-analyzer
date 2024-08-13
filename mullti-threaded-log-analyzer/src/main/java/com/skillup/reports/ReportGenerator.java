package com.skillup.reports;

import java.util.Collection;

import com.skillup.model.LogEntry;

/**
 * This interface defines the contract for generating reports from processed log data.
 * (Optional if you only need one report format)
 */
public interface ReportGenerator {

    /**
     * Generates a report based on the provided log data.
     * 
     * @param logEntries A collection of processed log entries (e.g., List<LogEntry>).
     * @throws ReportGenerationException If there's an error while generating the report.
     */
    void generateReport(Collection<LogEntry> logEntries) throws ReportGenerationException;
  }
  