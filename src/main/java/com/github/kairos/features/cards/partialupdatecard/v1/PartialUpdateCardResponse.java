package com.github.kairos.features.cards.partialupdatecard.v1;

import java.util.Set;

public record PartialUpdateCardResponse(
	String name,
	int attack,
	int health,
	int armor,
	String illustration,
	String rarity,
	Set<String> elements,
	String nature,
	int cost
) {
}
