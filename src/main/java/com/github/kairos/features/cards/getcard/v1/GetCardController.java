package com.github.kairos.features.cards.getcard.v1;

import com.github.kairos.middleware.exceptionhandler.exceptions.CardNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/card")
public class GetCardController {
	private final GetCardHandler getCardHandler;

	public GetCardController(GetCardHandler getCardHandler) {
		this.getCardHandler = getCardHandler;
	}

	@GetMapping("/{id}")
	public ResponseEntity<GetCardResponse> getCardById(@PathVariable Long id) {
		Optional<GetCardResponse> getCardResponse = getCardHandler.handle(id);
		return getCardResponse.map(ResponseEntity::ok).orElseThrow(() -> new CardNotFoundException(id));
	}
}
