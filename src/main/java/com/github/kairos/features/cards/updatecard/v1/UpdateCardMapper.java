package com.github.kairos.features.cards.updatecard.v1;

import com.github.kairos.features.cards.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UpdateCardMapper {
	@Mapping(target = "cost", source = "cost")
	UpdateCardResponse toUpdateCardResponse(Card card, int cost);
}
