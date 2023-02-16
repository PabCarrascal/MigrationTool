package org.example.mappers;

import org.example.entities.Person;
import org.example.entities.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WorkerMapper {

  @Mapping(source = "name", target = "name")
  @Mapping(source = "jobTitle", target = "category")
  @Mapping(expression = "java(person.getDni() + \"--W\")", target = "id")
  Worker mapPersonToWorker(Person person);
}
