package com.github.kairos.features.cards.createcard.v1;

public interface CreateCardHandler {
	CreateCardResponse handle(CreateCardCommand createCardCommand);
}
