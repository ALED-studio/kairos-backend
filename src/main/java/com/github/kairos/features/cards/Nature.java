package com.github.kairos.features.cards;

public enum Nature {
	MORTAL(0),
	HERO(1),
	MONSTER(2),
	OLYMPIAN(3),
	TITAN(4),
	PRIMORDIAL(5);

	private final int value;

	Nature(int value) {
		this.value = value;
	}

	public static Nature fromValue(int value) {
		return switch (value) {
			case 0 -> Nature.MORTAL;
			case 1 -> Nature.HERO;
			case 2 -> Nature.MONSTER;
			case 3 -> Nature.OLYMPIAN;
			case 4 -> Nature.TITAN;
			case 5 -> Nature.PRIMORDIAL;
			default -> throw new IllegalArgumentException("Unknown Nature value: " + value);
		};
	}

	public int value() {
		return value;
	}
}
