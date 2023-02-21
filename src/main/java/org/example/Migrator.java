package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.AlphaResponse;
import org.example.entities.MongoJson;
import org.example.mappers.MongoMapper;
import org.mapstruct.factory.Mappers;

public class Migrator {

  private final MongoMapper mapper = Mappers.getMapper(MongoMapper.class);

  public String migrate(String json) {

    String cad = "";
    ObjectMapper objectMapper = new ObjectMapper();
    AlphaResponse alphaResponse;
    try {
      alphaResponse = objectMapper.readValue(json, AlphaResponse.class);
      //MongoJson mongoJson = MongoAlphaMapper.mapAlphaResponseToMongoJsonList(alphaResponse);
      MongoJson mongoJson = mapper.mapAlphaResponseToMongoJson(alphaResponse);
      cad = objectMapper.writeValueAsString(mongoJson);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    return cad;
  }
}
