package com.client.catalog.service.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private T response;
    private Boolean success = true;
    private String message;
    private String errorCode;

}
