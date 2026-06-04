package com.github.kairos.features.cards.partialupdatecard.v1;

import com.github.kairos.features.cards.Card;
import com.github.kairos.features.cards.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PartialUpdateCardHandlerImpl implements PartialUpdateCardHandler {
	private final CardRepository cardRepository;
	private final PartialUpdateCardMapper partialUpdateCardMapper;

	@Override
	public PartialUpdateCardResponse handle(Long id, PartialUpdateCardCommand partialUpdateCardCommand) {
		Card existingCard = cardRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found"));
		partialUpdateCardMapper.updateCardFromCommand(partialUpdateCardCommand, existingCard);
		Card savedCard = cardRepository.save(existingCard);
		return partialUpdateCardMapper.toPartialUpdateCardResponse(savedCard, savedCard.cost());
	}
}
