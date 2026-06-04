package com.github.kairos.features.cards.updatecard.v1;

import com.github.kairos.features.cards.Element;
import com.github.kairos.features.cards.Nature;
import com.github.kairos.features.cards.Rarity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record UpdateCardCommand(
	@NotBlank(message = "name must not be blank")
	@Size(max = 30, message = "name must contain at most 30 characters")
	String name,

	@NotNull(message = "attack is required")
	Integer attack,

	@NotNull(message = "health is required")
	@Min(value = 0, message = "health must be greater than or equal to 0")
	Integer health,

	@NotNull(message = "armor is required")
	@Min(value = 0, message = "armor must be greater than or equal to 0")
	Integer armor,

	@NotBlank(message = "illustration must not be blank")
	@Size(max = 255, message = "illustration must contain at most 255 characters")
	String illustration,

	@NotNull(message = "rarity is required")
	Rarity rarity,

	@NotEmpty(message = "elements must contain at least one element")
	Set<Element> elements,

	@NotNull(message = "nature is required")
	Nature nature
) {
}
