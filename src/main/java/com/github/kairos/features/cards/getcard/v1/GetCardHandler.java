package com.github.kairos.features.cards.getcard.v1;

import java.util.Optional;

public interface GetCardHandler {
	Optional<GetCardResponse> handle(Long id);
}
