package com.github.kairos.features.cards.getcard.v1;

import com.github.kairos.features.cards.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetCardHandlerImpl implements GetCardHandler {
	private final CardRepository cardRepository;
	private final GetCardMapper getCardMapper;

	@Override
	public Optional<GetCardResponse> handle(Long id) {
		return cardRepository.findById(id).map(card -> getCardMapper.toGetCardResponse(card, card.cost()));
	}

}
