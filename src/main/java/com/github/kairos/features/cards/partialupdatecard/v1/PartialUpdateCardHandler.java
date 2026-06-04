package com.github.kairos.features.cards.partialupdatecard.v1;

public interface PartialUpdateCardHandler {
	PartialUpdateCardResponse handle(Long id, PartialUpdateCardCommand partialUpdateCardCommand);
}
