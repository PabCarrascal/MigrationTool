package org.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Creator {

  public void parse(String json) {

    ObjectMapper mapper = new ObjectMapper(new JsonFactory());
    JsonNode rootNode = null;
    try {
      rootNode = mapper.readTree(json);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    Iterator<Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
    while (fieldsIterator.hasNext()) {
      Map.Entry<String, JsonNode> field = fieldsIterator.next();
      System.out.println("Key: " + field.getKey() + "\tValue: " + field.getValue());
    }
  }
}
