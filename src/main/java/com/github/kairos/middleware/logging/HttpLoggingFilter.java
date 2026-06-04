package com.github.kairos.middleware.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HttpLoggingFilter extends OncePerRequestFilter {

	private static final Logger LOGGER = LogManager.getLogger(HttpLoggingFilter.class);
	private static final int CACHE_LIMIT = 10_000;

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		String path = request.getRequestURI();
		return path.startsWith("/actuator");
	}

	@Override
	protected void doFilterInternal(
		HttpServletRequest request,
		HttpServletResponse response,
		FilterChain filterChain
	) throws ServletException, IOException {

		ContentCachingRequestWrapper wrappedRequest =
			new ContentCachingRequestWrapper(request, CACHE_LIMIT);
		ContentCachingResponseWrapper wrappedResponse =
			new ContentCachingResponseWrapper(response);

		long start = System.currentTimeMillis();

		if (LOGGER.isInfoEnabled()) {
			String requestBody = bodyAsString(
				wrappedRequest.getContentAsByteArray(),
				wrappedRequest.getCharacterEncoding()
			);

			LOGGER.info(
				"HTTP request method={} path={} body={}",
				wrappedRequest.getMethod(),
				wrappedRequest.getRequestURI(),
				requestBody
			);
		}

		try {
			filterChain.doFilter(wrappedRequest, wrappedResponse);
		} catch (Exception ex) {
			LOGGER.error(
				"HTTP exception method={} path={} message={}",
				request.getMethod(),
				request.getRequestURI(),
				ex.getMessage(),
				ex
			);
			throw ex;
		} finally {
			long durationMs = System.currentTimeMillis() - start;

			if (LOGGER.isInfoEnabled()) {
				String responseBody = bodyAsString(
					wrappedResponse.getContentAsByteArray(),
					wrappedResponse.getCharacterEncoding()
				);

				LOGGER.info(
					"HTTP request method={} path={} status={} durationMs={} body={}",
					wrappedRequest.getMethod(),
					wrappedRequest.getRequestURI(),
					wrappedResponse.getStatus(),
					durationMs,
					responseBody
				);
			}

			wrappedResponse.copyBodyToResponse();
		}
	}

	private String bodyAsString(byte[] content, String encoding) {
		if (content == null || content.length == 0) {
			return "";
		}

		Charset charset = encoding != null
			? Charset.forName(encoding)
			: StandardCharsets.UTF_8;

		return new String(content, charset);
	}
}
