package com.github.kairos.features.cards.getallcard.v1;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class GetAllCardController {
	private final GetAllCardHandler getAllCardHandler;

	private static final int DEFAULT_PAGINATION_SIZE = 10;
	private static final String DEFAULT_PAGINATION_SORT = "name";

	public GetAllCardController(GetAllCardHandler getAllCardHandler) {
		this.getAllCardHandler = getAllCardHandler;
	}

	@GetMapping()
	public Page<GetAllCardResponse> getAllCard(
		@ParameterObject
		@PageableDefault(
			size = DEFAULT_PAGINATION_SIZE,
			sort = DEFAULT_PAGINATION_SORT
		) Pageable pageable
	) {
		return getAllCardHandler.handle(pageable);
	}
}
