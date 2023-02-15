package com.client.catalog.service.exception;

import lombok.Getter;

@Getter
public enum ErrorCodesAndMessages {
    PRODUCT_NOT_FOUND_ERROR("STS0000001","Product is not available for given id"),
    INPUT_FORMAT_ERROR("STS0000001","Please check the input format"),
    SENT_TICKER_NAME_BLANK("SENT000001","itemId must not be blank"),
    SENT_CURRENCY_BLANK("SENT000002","name must not be blank"),
    ;

   private String code;
   private String message;
   ErrorCodesAndMessages(String code, String message){
       this.code = code;
       this.message = message;
   }

}
