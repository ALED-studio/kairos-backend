package com.github.kairos.features.cards.getallcard.v1;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetAllCardHandler {
	Page<GetAllCardResponse> handle(Pageable pageable);
}
