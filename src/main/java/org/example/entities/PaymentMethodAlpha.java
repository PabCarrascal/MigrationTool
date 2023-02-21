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
public class PaymentMethodAlpha {

  private String device_channel;
  private String device_type;
  private Integer id_payment_method;
  private String name_payment_method;
  private List<AttributeAlpha> attributes;
  private Boolean available;
}
