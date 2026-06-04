package com.github.kairos.features.cards.createcard.v1;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/card")
public class CreateCardController {
	private final CreateCardHandler createCardHandler;

	public CreateCardController(CreateCardHandler createCardHandler) {
		this.createCardHandler = createCardHandler;
	}

	@PostMapping
	public ResponseEntity<CreateCardResponse> createCard(
		@Valid @RequestBody CreateCardCommand createCardCommand
	) {
		CreateCardResponse createCardResponse = createCardHandler.handle(createCardCommand);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(createCardResponse.id()).toUri();

		return ResponseEntity.created(location).body(createCardResponse);
	}
}
