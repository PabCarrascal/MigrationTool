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
public class AlphaResponse {

  private Integer id_location;
  private List<PaymentMethodAlpha> payment_methods;
}
