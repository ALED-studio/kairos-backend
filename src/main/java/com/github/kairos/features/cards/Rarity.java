package com.github.kairos.features.cards;

public enum Rarity {
	COMMON(0),
	UNCOMMON(1),
	RARE(2),
	EPIC(3),
	LEGENDARY(4);

	private final int value;

	Rarity(int value) {
		this.value = value;
	}

	public static Rarity fromValue(int value) {
		return switch (value) {
			case 0 -> Rarity.COMMON;
			case 1 -> Rarity.UNCOMMON;
			case 2 -> Rarity.RARE;
			case 3 -> Rarity.EPIC;
			case 4 -> Rarity.LEGENDARY;
			default -> throw new IllegalArgumentException("Unknown Rarity value: " + value);
		};
	}

	public int value() {
		return value;
	}
}
