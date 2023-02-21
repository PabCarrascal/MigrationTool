package org.example.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.example.entities.Account;
import org.example.entities.AlphaResponse;
import org.example.entities.AttributeAlpha;
import org.example.entities.AttributePaymentMethod;
import org.example.entities.AttributePaymentMethodData;
import org.example.entities.MongoJson;
import org.example.entities.PaymentMethodAlpha;
import org.example.entities.PaymentMethodMongo;

public class MongoAlphaMapper {

  public static MongoJson mapAlphaResponseToMongoJsonList(AlphaResponse alphaResponse) {
    return MongoJson.builder()
        .accounts(List.of(mapAlphaResponseToAccount(alphaResponse)))
        .channel(alphaResponse.getPayment_methods().get(0).getDevice_channel())
        .device(alphaResponse.getPayment_methods().get(0).getDevice_type())
        .paymentMethods(alphaResponse.getPayment_methods().stream().map(
            MongoAlphaMapper::mapPaymentMethodAlphaToPaymentMethodMongo).collect(
            Collectors.toList()))
        .build();
  }

  private static Account mapAlphaResponseToAccount(AlphaResponse alphaResponse) {
    return Account.builder()
        .locationId(alphaResponse.getId_location())
        .build();
  }

  private static PaymentMethodMongo mapPaymentMethodAlphaToPaymentMethodMongo(PaymentMethodAlpha paymentMethodAlpha) {

    return PaymentMethodMongo.builder()
        .paymentMethodId(paymentMethodAlpha.getId_payment_method())
        .paymentMethodName(paymentMethodAlpha.getName_payment_method())
        .attributePaymentMethod(mapPaymentMethodAlphaToAttributePaymentMethod(paymentMethodAlpha))
        .active(paymentMethodAlpha.getAvailable())
        .build();
  }

  private static AttributePaymentMethod mapPaymentMethodAlphaToAttributePaymentMethod(PaymentMethodAlpha paymentMethodAlpha) {

    return AttributePaymentMethod.builder()
        .attributePaymentMethodData(
            paymentMethodAlpha.getAttributes().stream().map(MongoAlphaMapper::mapAttributeAlphaToAttributeData).collect(
                Collectors.toList()))
        .build();
  }

  private static AttributePaymentMethodData mapAttributeAlphaToAttributeData(AttributeAlpha attributeAlpha) {

    return AttributePaymentMethodData.builder()
        .description(attributeAlpha.getName())
        .validation(attributeAlpha.getValidation())
        .visible(attributeAlpha.getCustomer_visible())
        .required(attributeAlpha.getMandatory())
        .encrypted(attributeAlpha.getIs_ciphered())
        .build();
  }
}
