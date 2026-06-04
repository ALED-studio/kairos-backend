package com.github.kairos.features.cards.updatecard.v1;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class UpdateCardController {
	private final UpdateCardHandler updateCardHandler;

	public UpdateCardController(UpdateCardHandler updateCardHandler) {
		this.updateCardHandler = updateCardHandler;
	}

	@PutMapping("/{id}")
	public ResponseEntity<UpdateCardResponse> updateCardById(
		@PathVariable Long id,
		@Valid @RequestBody UpdateCardCommand updateCardCommand
	) {
		UpdateCardResponse updateCardResponse = updateCardHandler.handle(id, updateCardCommand);
		return ResponseEntity.ok(updateCardResponse);
	}
}
