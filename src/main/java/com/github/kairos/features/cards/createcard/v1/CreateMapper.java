package com.github.kairos.features.cards.createcard.v1;

import com.github.kairos.features.cards.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CreateMapper {

	@Mapping(target = "id", ignore = true)
	Card toCard(CreateCardCommand createCardCommand);

	@Mapping(target = "cost", source = "cost")
	CreateCardResponse toCreateCardResponse(Card card, int cost);
}
