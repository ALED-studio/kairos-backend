package com.github.kairos.features.cards.createcard.v1;

import java.util.Set;

public record CreateCardResponse(
	int id,
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
