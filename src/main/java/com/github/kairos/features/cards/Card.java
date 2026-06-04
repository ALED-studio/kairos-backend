package com.github.kairos.features.cards;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "card")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int attack;

	@Column(nullable = false)
	private int health;

	@Column(nullable = false)
	private int armor;

	@Column(nullable = false)
	private String illustration;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private Rarity rarity;

	@ElementCollection
	@CollectionTable(
		name = "card_elements",
		joinColumns = @JoinColumn(name = "card_id")
	)
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "element", nullable = false)
	private Set<Element> elements = new HashSet<>();

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private Nature nature;

	@Transient
	public int cost() {
		return switch (rarity) {
			case COMMON -> 1;
			case UNCOMMON -> 2;
			case RARE -> 3;
			case EPIC -> 4;
			case LEGENDARY -> 5;
			case null, default -> 0;
		};
	}
}
