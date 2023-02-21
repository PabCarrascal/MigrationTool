package org.example.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttributePaymentMethod {

  private String attributeId;
  private String paymentMethodName;
  private List<AttributePaymentMethodData> attributePaymentMethodData;
}
