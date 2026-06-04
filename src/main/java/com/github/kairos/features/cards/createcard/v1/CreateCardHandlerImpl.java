package com.github.kairos.features.cards.createcard.v1;

import com.github.kairos.features.cards.Card;
import com.github.kairos.features.cards.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCardHandlerImpl implements CreateCardHandler {
	private final CardRepository cardRepository;
	private final CreateMapper createMapper;

	@Override
	public CreateCardResponse handle(CreateCardCommand createCardCommand) {
		Card cardToCreate = createMapper.toCard(createCardCommand);
		Card createdCard = cardRepository.save(cardToCreate);
		return createMapper.toCreateCardResponse(createdCard, createdCard.cost());
	}
}
