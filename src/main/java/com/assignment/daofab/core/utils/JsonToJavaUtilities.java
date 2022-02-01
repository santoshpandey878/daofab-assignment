package com.assignment.daofab.core.utils;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.json.JsonSanitizer;

/**
 * Utility class contains methods for json to java conversion.
 */
public class JsonToJavaUtilities extends ObjectMapper {
  private static final long serialVersionUID = 1L;

  private static final Logger log = LoggerFactory.getLogger(JsonToJavaUtilities.class);

  private static JsonToJavaUtilities  jsonToJavaUtils;

  /**
  * Private constructor
  */
  private JsonToJavaUtilities(){

  }

  public static JsonToJavaUtilities getInstance(){
    if(null == jsonToJavaUtils){
      jsonToJavaUtils = new JsonToJavaUtilities();
    }
    return jsonToJavaUtils;
  }

  /**
  * Method to convert Json string into Java object
  * @param jsonString
  * @param cls
  * @return
  * @throws IOException
  */
  public static <T> T jsonObjectToJavaObject(String jsonString, Class<T> cls) {
    try {
      return getInstance().readValue(JsonSanitizer.sanitize(jsonString), cls);
    } catch (IOException e) {
    log.error(e.getMessage(), e);
    return null;
    }
  }

}
