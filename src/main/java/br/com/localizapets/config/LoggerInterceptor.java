package br.com.localizapets.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LoggerInterceptor implements Filter {

    private static String CORRELATION_ID_NAME = "correlationId";
    private String correlationId;

    private String searchCorrelationHeader(ServletRequest request) {
        var requestHttp = (HttpServletRequest) request;
        correlationId = requestHttp.getHeader("correlation-id");
        if (Objects.isNull(correlationId)) {
            return UUID.randomUUID().toString();
        }
        return correlationId;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        correlationId = searchCorrelationHeader(servletRequest);
        MDC.put(CORRELATION_ID_NAME, correlationId);
        filterChain.doFilter(servletRequest, servletResponse);

    }
}