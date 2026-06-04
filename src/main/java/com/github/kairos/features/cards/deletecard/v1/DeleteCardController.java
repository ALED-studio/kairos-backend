package com.github.kairos.features.cards.deletecard.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class DeleteCardController {
	private final DeleteCardHandler deleteCardHandler;

	public DeleteCardController(DeleteCardHandler deleteCardHandler) {
		this.deleteCardHandler = deleteCardHandler;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCardById(@PathVariable Long id) {
		deleteCardHandler.handle(id);
		return ResponseEntity.noContent().build();
	}
}
