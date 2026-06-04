package com.github.kairos.features.cards.createcard.v1;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record CreateCardCommand(
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

	@NotBlank(message = "rarity is required")
	String rarity,

	@NotEmpty(message = "elements must contain at least one element")
	Set<String> elements,

	@NotBlank(message = "nature is required")
	String nature
) {
}
