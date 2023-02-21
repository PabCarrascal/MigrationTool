package org.example.mappers;

import org.example.entities.Account;
import org.example.entities.AlphaResponse;
import org.example.entities.AttributeAlpha;
import org.example.entities.AttributePaymentMethod;
import org.example.entities.AttributePaymentMethodData;
import org.example.entities.MongoJson;
import org.example.entities.PaymentMethodAlpha;
import org.example.entities.PaymentMethodMongo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MongoMapper {

  @Mapping(target = "accounts", expression = "java(List.of(mapAlphaResponseToAccount(alphaResponse)))")
  @Mapping(target = "paymentMethods", source = "payment_methods")
  MongoJson mapAlphaToMongo(AlphaResponse alphaResponse);

  @Mapping(target = "locationId", source = "id_location")
  Account mapAlphaResponseToAccount(AlphaResponse alphaResponse);

  @Mapping(target = "paymentMethodId", source = "id_payment_method")
  @Mapping(target = "paymentMethodName", source = "name_payment_method")
  @Mapping(target = "attributePaymentMethod", expression = "java(mapPaymentMethodAlphaToAttributePaymentMethod(paymentMethodAlpha))")
  @Mapping(target = "active", source = "available")
  PaymentMethodMongo mapPaymentMethodAlphaToPaymentMethodMongo(PaymentMethodAlpha paymentMethodAlpha);

  @Mapping(target = "attributeId", source = "id_payment_method")
  @Mapping(target = "paymentMethodName", source = "name_payment_method")
  @Mapping(target = "attributePaymentMethodData", source = "attributes")
  AttributePaymentMethod mapPaymentMethodAlphaToAttributePaymentMethod(PaymentMethodAlpha paymentMethodAlpha);

  @Mapping(target = "validation", source = "validation")
  @Mapping(target = "visible", source = "customer_visible")
  @Mapping(target = "required", source = "mandatory")
  @Mapping(target = "encrypted", source = "is_ciphered")
  AttributePaymentMethodData mapAttributeAlphaToAttributeData(AttributeAlpha attributeAlpha);
}
