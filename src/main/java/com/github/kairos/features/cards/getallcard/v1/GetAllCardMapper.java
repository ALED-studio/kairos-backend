package com.github.kairos.features.cards.getallcard.v1;

import com.github.kairos.features.cards.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GetAllCardMapper {

	@Mapping(target = "cost", source = "cost")
	GetAllCardResponse toGetAllCardResponse(Card card, int cost);
}
