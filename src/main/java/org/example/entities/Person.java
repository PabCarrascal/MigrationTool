package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

  private String dni;
  private String name;
  private String middleName;
  private String surname;
  private String jobTitle;
}
