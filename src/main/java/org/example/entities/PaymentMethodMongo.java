package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodMongo {

  private Integer paymentMethodId;
  private String paymentMethodName;
  private Integer paymentMethodPosition;
  private String paymentMethodIcon;
  private AttributePaymentMethod attributePaymentMethod;
  private Boolean active;
}
