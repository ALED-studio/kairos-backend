package com.github.kairos.features.cards.updatecard.v1;

public interface UpdateCardHandler {
	UpdateCardResponse handle(Long id, UpdateCardCommand updateCardCommand);
}
