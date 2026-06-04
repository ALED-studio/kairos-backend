package com.github.kairos.features.cards.partialupdatecard.v1;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class PartialUpdateCardController {
	private final PartialUpdateCardHandler partialUpdateCardHandler;

	public PartialUpdateCardController(PartialUpdateCardHandler partialUpdateCardHandler) {
		this.partialUpdateCardHandler = partialUpdateCardHandler;
	}

	@PatchMapping("/{id}")
	public ResponseEntity<PartialUpdateCardResponse> partiallyUpdateCardById(
		@PathVariable Long id,
		@Valid @RequestBody PartialUpdateCardCommand partialUpdateCardCommand
	) {
		PartialUpdateCardResponse partialUpdateCardResponse = partialUpdateCardHandler.handle(id, partialUpdateCardCommand);
		return ResponseEntity.ok(partialUpdateCardResponse);
	}
}
