package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.AlphaResponse;
import org.example.entities.MongoJson;
import org.example.mappers.MongoAlphaMapper;

public class Migrator {

  public String migrate(String json) {

    String cad = "";
    ObjectMapper objectMapper = new ObjectMapper();
    AlphaResponse alphaResponse;
    try {
      alphaResponse = objectMapper.readValue(json, AlphaResponse.class);
      MongoJson mongoJson = MongoAlphaMapper.mapAlphaToMongo(alphaResponse);
      cad = objectMapper.writeValueAsString(mongoJson);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    return cad;
  }
}
