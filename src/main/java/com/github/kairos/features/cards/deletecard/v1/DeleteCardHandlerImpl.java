package com.github.kairos.features.cards.deletecard.v1;

import com.github.kairos.features.cards.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCardHandlerImpl implements DeleteCardHandler {
	private final CardRepository cardRepository;

	@Override
	public void handle(Long id) {
		cardRepository.findById(id).ifPresent(cardRepository::delete);
	}
}
