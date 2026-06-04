package com.github.kairos.features.cards.getallcard.v1;

import com.github.kairos.features.cards.Card;
import com.github.kairos.features.cards.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllCardHandlerImpl implements GetAllCardHandler {
	private final CardRepository cardRepository;
	private final GetAllCardMapper getAllCardMapper;

	@Override
	public Page<GetAllCardResponse> handle(Pageable pageable) {
		Page<Card> cards = cardRepository.findAll(pageable);
		return cards.map(card -> getAllCardMapper.toGetAllCardResponse(card, card.cost()));
	}
}
