package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttributeAlpha {

  private String name;
  private String validation;
  private Boolean mandatory;
  private Boolean customer_visible;
  private Boolean is_ciphered;
}
