package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

  private String accountCode;
  private Integer locationId;
  private String origin;
  private String tenantISO;
  private String tenantDescription;
  private String countryISO;
  private String countryDescription;
}
