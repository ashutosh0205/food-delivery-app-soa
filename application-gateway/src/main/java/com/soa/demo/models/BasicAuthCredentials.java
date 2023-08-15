package com.soa.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasicAuthCredentials {
    private String user;

    private String password;

    private boolean authenticated;
}
