package org.example.mappers;

import org.example.entities.AlphaResponse;
import org.example.entities.MongoJson;
import org.example.entities.PaymentMethodAlpha;
import org.example.entities.PaymentMethodMongo;
import org.mapstruct.Mapper;

@Mapper
public interface MongoMapper {

  MongoJson mapAlphaToMongo(AlphaResponse alphaResponse);

  PaymentMethodMongo mapMethodAlphaToMethodMongo(PaymentMethodAlpha paymentMethodAlpha);
}
