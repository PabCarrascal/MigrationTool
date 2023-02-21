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
public class MongoJson {

  private List<Account> accounts;
  private String channel;
  private String device;
  private String configurationVersion;
  private List<Currency> currencies;
  private List<PaymentMethodMongo> paymentMethods;
}
