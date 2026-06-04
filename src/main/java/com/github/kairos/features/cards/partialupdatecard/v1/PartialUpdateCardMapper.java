package com.github.kairos.features.cards.partialupdatecard.v1;

import com.github.kairos.features.cards.Card;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PartialUpdateCardMapper {

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "id", ignore = true)
	void updateCardFromCommand(PartialUpdateCardCommand command, @MappingTarget Card card);

	@Mapping(target = "cost", source = "cost")
	PartialUpdateCardResponse toPartialUpdateCardResponse(Card card, int cost);
}
