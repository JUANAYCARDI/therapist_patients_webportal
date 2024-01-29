package com.psi.satrello.user.util;

import com.psi.satrello.user.exception.InvalidTokenException;
import com.psi.satrello.user.exception.UnauthorizedProfileException;
import com.psi.satrello.user.model.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/* Contains methods to call the authorization API and validate de auth token */
@Component
public class TokenValidator {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${authorization.url}")
    private String auth_url;

    /* This function validates the token by asking the authorization microservice */
    public AuthResponse validateToken(String tokenHeader) {
        if (tokenHeader == null || !tokenHeader.startsWith("Bearer ")) {
            throw new InvalidTokenException("Invalid authorization token", 401);
        }

        // Prepare header
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", tokenHeader);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<AuthResponse> response;
        try {
            response = restTemplate.exchange(auth_url, HttpMethod.GET, entity,
                    AuthResponse.class);
        }
        catch (HttpClientErrorException.Unauthorized ex) {
            throw new InvalidTokenException("Invalid authorization token", 401);
        }

        int statusCode = response.getStatusCode().value();
        if (statusCode != 200) {
            throw new InvalidTokenException("Invalid authorization token", 400);
        }

        return response.getBody();
    }

    public void assertTokenPersonalId(String tokenHeader, String personalId) {
        AuthResponse authResponse = validateToken(tokenHeader);
        if (!authResponse.getPersonalId().equalsIgnoreCase(personalId)) {
            throw new UnauthorizedProfileException("The account does not have permission to access this profile", 401);
        }
    }

    public void assertToken(String tokenHeader) {
        validateToken(tokenHeader);
    }
}
