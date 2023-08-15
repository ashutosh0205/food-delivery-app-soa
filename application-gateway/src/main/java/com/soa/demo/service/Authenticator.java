package com.soa.demo.service;

import com.soa.demo.models.BasicAuthCredentials;
import org.springframework.http.server.reactive.ServerHttpRequest;

public interface Authenticator {

    BasicAuthCredentials authenticate(ServerHttpRequest request);
}
