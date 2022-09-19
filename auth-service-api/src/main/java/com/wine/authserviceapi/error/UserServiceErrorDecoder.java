package com.wine.authserviceapi.error;

import feign.Response;
import feign.codec.ErrorDecoder;

public class UserServiceErrorDecoder implements ErrorDecoder {
    private static final int UNAUTHORIZED = 401;

    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case UNAUTHORIZED:
                throw new UnauthorizedException();
            default:
                throw new RuntimeException("Unknown error");
        }
    }
}
