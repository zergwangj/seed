package com.company.project.seed.shiro;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

@Data
public class JWTAuthenticationToken implements AuthenticationToken {
    private Object userId;
    private String token;

    public JWTAuthenticationToken(Object userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return getUserId();
    }

    @Override
    public Object getCredentials() {
        return getToken();
    }
}
