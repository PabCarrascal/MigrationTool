package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttributePaymentMethodData {

  private String description;
  private String validation;
  private Boolean visible;
  private Boolean required;
  private Boolean encrypted;
}
