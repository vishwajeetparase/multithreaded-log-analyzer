package com.skillup.parsers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.skillup.model.LogEntry;
import com.skillup.model.LogEntry.LogLevel;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This class implements the LogParser interface specifically for parsing JSON-formatted log entries.
 * It utilizes the Jackson ObjectMapper library for efficient JSON parsing.
 */
public class JsonLogParser implements LogParser {
  
    @Override
    public List<LogEntry> parseLogEntry(String logLine) throws ParseException {
      List<LogEntry> logEntries = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(logLine);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String timestamp = jsonObject.getString("timestamp");
                String message = jsonObject.getString("message");
                LogLevel level = LogLevel.valueOf(jsonObject.getString("level"));
                logEntries.add(new LogEntry(timestamp, message, level));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logEntries;
    }
  }
  