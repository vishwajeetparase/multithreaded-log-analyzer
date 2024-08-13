package com.skillup.processors;

import com.skillup.model.LogEntry;
import com.skillup.model.LogEntry.LogLevel;

/**
 * This class implements the LogProcessor interface to identify critical events and trigger alerts based on log entries.
 * It defines rules for identifying critical conditions and sending notifications (e.g., email, SMS).
 */
public class AlertingProcessor implements LogProcessor {

    private final AlertingService alertingService; // Dependency for sending alerts
  
    public AlertingProcessor(AlertingService alertingService) {
      this.alertingService = alertingService;
    }
  
    @Override
    public void process(LogEntry logEntry) {
      if (logEntry.getLevel() == LogLevel.ERROR && logEntry.getMessage().contains("critical failure")) {
        String message = "Critical failure detected in log: " + logEntry.getMessage();
        alertingService.sendAlert(message); // Delegate alert sending to the service
      }
      // Add more rules for identifying other critical events and sending alerts
    }
  }
  