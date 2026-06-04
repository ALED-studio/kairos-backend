package com.github.kairos.features.cards.partialupdatecard.v1;

import com.github.kairos.features.cards.Element;
import com.github.kairos.features.cards.Nature;
import com.github.kairos.features.cards.Rarity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record PartialUpdateCardCommand(
	@Size(max = 30, message = "name must contain at most 30 characters")
	String name,
	Integer attack,
	@Min(value = 0, message = "health must be greater than or equal to 0")
	Integer health,
	@Min(value = 0, message = "armor must be greater than or equal to 0")
	Integer armor,
	@Size(max = 255, message = "illustration must contain at most 255 characters")
	String illustration,
	Rarity rarity,
	Set<Element> elements,
	Nature nature
) {
}
