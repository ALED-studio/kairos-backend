package com.github.kairos.features.cards.getcard.v1;

import com.github.kairos.features.cards.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GetCardMapper {

	@Mapping(target = "cost", source = "cost")
	GetCardResponse toGetCardResponse(Card card, int cost);
}
