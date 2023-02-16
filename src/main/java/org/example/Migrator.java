package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Person;
import org.example.entities.Worker;
import org.example.mappers.WorkerMapper;
import org.mapstruct.factory.Mappers;

public class Migrator {

  private final WorkerMapper mapper = Mappers.getMapper(WorkerMapper.class);

  public String migrate(String json) {

    String cad = "";
    ObjectMapper objectMapper = new ObjectMapper();
    Person person;
    try {
      person = objectMapper.readValue(json, Person.class);
      Worker worker = mapper.mapPersonToWorker(person);
      cad = objectMapper.writeValueAsString(worker);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    return cad;
  }
}
