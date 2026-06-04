CREATE TABLE card
(
	id           BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name         VARCHAR(50)  NOT NULL,
	attack       INTEGER      NOT NULL,
	health       INTEGER      NOT NULL,
	armor        INTEGER      NOT NULL,
	illustration VARCHAR(255) NOT NULL,
	rarity       INTEGER      NOT NULL,
	nature       INTEGER      NOT NULL
);

CREATE TABLE card_elements
(
	card_id BIGINT  NOT NULL,
	element INTEGER NOT NULL,
	CONSTRAINT fk_card_elements_card
		FOREIGN KEY (card_id) REFERENCES card (id)
);
