package com.skillup.filter;

import com.skillup.model.LogEntry;

public class MessageFilter implements LogEntryFilter {

    private final String keyword;
  
    public MessageFilter(String keyword) {
      this.keyword = keyword;
    }
  
    @Override
    public boolean accept(LogEntry logEntry) {
      return logEntry.getMessage().contains(keyword);
    }
  }
  