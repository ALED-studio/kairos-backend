package com.github.kairos.features.cards;

public enum Element {
	NEUTRAL(0),
	FIRE(1),
	WATER(2),
	THUNDER(3),
	EARTH(4),
	WIND(5),
	LIGHT(6),
	SHADOW(7);

	private final int value;

	Element(int value) {
		this.value = value;
	}

	public static Element fromValue(int value) {
		return switch (value) {
			case 0 -> Element.NEUTRAL;
			case 1 -> Element.FIRE;
			case 2 -> Element.WATER;
			case 3 -> Element.THUNDER;
			case 4 -> Element.EARTH;
			case 5 -> Element.WIND;
			case 6 -> Element.LIGHT;
			case 7 -> Element.SHADOW;
			default -> throw new IllegalArgumentException("Unknown Element value: " + value);
		};
	}

	public int value() {
		return value;
	}
}
