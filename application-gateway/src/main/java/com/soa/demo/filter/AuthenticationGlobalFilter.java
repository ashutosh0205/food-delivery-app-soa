package com.soa.demo.filter;

import com.soa.demo.exception.AuthenticationException;
import com.soa.demo.service.Authenticator;
import com.soa.demo.models.BasicAuthCredentials;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class AuthenticationGlobalFilter implements GlobalFilter, Ordered {

    public static final String AUTH_CREDENTIALS = "AUTH_CREDENTIALS";
    private Authenticator authenticator;

    @Autowired
    public AuthenticationGlobalFilter(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("AuthenticationGlobalFilter - start");
        try {
            BasicAuthCredentials credentials = authenticator.authenticate(exchange.getRequest());
            exchange.getAttributes().put(AUTH_CREDENTIALS, credentials);
        } catch (AuthenticationException e) {
            log.info(e.getMessage());
            throw new AuthenticationException("Authentication failed");
        }
        log.info("AuthenticationGlobalFilter - end");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
