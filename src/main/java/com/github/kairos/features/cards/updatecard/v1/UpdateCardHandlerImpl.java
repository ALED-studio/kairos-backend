package com.github.kairos.features.cards.updatecard.v1;

import com.github.kairos.features.cards.Card;
import com.github.kairos.features.cards.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCardHandlerImpl implements UpdateCardHandler {
	private final CardRepository cardRepository;
	private final UpdateCardMapper updateCardMapper;

	@Override
	public UpdateCardResponse handle(
		Long id,
		UpdateCardCommand updateCardCommand
	) {
		Card card = cardRepository.findById(id).orElseThrow();
		card.setName(updateCardCommand.name());
		card.setArmor(updateCardCommand.armor());
		card.setHealth(updateCardCommand.health());
		card.setAttack(updateCardCommand.attack());
		card.setIllustration(updateCardCommand.illustration());
		card.setRarity(updateCardCommand.rarity());
		card.getElements().clear();
		card.getElements().addAll(updateCardCommand.elements());
		card.setNature(updateCardCommand.nature());
		Card updatedCard = cardRepository.save(card);
		return updateCardMapper.toUpdateCardResponse(updatedCard, updatedCard.cost());
	}
}
