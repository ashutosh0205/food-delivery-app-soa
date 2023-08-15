package com.soa.demo.service.impl;

import com.soa.demo.exception.AuthenticationException;
import com.soa.demo.models.BasicAuthCredentials;
import com.soa.demo.service.Authenticator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class BasicAuthenticator implements Authenticator
{

    public static Map<String, String> users= initUsers();

    private static Map<String, String> initUsers()
    {
        Map<String, String> users  = new HashMap<>();
        users.put("userA", "Apple#123!");
        users.put("userB", "Apple#123!");
        users.put("userC", "Apple#123!");
        return users;
    }

    public static final String PREFIX_BASIC = "Basic ";



    @Autowired
    public BasicAuthenticator() {
    }

    @Override
    public BasicAuthCredentials authenticate(ServerHttpRequest request) {
        BasicAuthCredentials credentials = this.extract(request);
        this.authenticate(credentials.getUser(), credentials.getPassword());

        return credentials;
    }

    public BasicAuthCredentials extract(ServerHttpRequest request) {
        List<String> headers = request.getHeaders().get(HttpHeaders.AUTHORIZATION);

        if (headers == null || headers.isEmpty()) {
            throw new AuthenticationException("Authorization header is missing!");
        }

        String authorization = headers.get(0);

        if (StringUtils.isEmpty(authorization)) {
            throw new AuthenticationException("No Cred Provided");
        }

        if (!authorization.startsWith(PREFIX_BASIC)) {
            throw new AuthenticationException("Invalid Authorization header provided");
        }
        String[] authSegments =  new String(Base64.getDecoder().decode(authorization.substring(PREFIX_BASIC.length()))).split(":");

        BasicAuthCredentials credentials = new BasicAuthCredentials();
        credentials.setUser(authSegments[0]);
        credentials.setPassword(authSegments[1]);

        return credentials;
    }

    public void authenticate(String user, String password) {
        if (users.get(user) == null) {
            throw new AuthenticationException("Invalid user " + user);
        }

        if (!users.get(user).equalsIgnoreCase(password)) {
            throw new AuthenticationException("Invalid password!");
        }
    }
}
