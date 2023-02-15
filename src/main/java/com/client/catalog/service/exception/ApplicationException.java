package com.client.catalog.service.exception;

import lombok.Getter;

@Getter
public class ApplicationException extends Exception {
    private static final long serialVersionUID = 58365668L;

    private String code;
    private String message;
    private ErrorCodesAndMessages errorCodesAndMessages;

    public ApplicationException(ErrorCodesAndMessages errorCodesAndMessages){
        super(errorCodesAndMessages.getCode()+" : "+errorCodesAndMessages.getMessage());
        this.errorCodesAndMessages = errorCodesAndMessages;
    }

    public ApplicationException(ErrorCodesAndMessages errorCodesAndMessages, Throwable exception){
        super(exception);
        this.errorCodesAndMessages = errorCodesAndMessages;
    }

}
