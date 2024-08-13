package com.skillup.util;

public class StringUtils {

    public static boolean isEmpty(String str) {
      return str == null || str.isEmpty();
    }
  
    public static String capitalizeFirstLetter(String str) {
      if (isEmpty(str)) {
        return str;
      }
      return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    // Add more utility methods for string manipulation as needed
  }
  