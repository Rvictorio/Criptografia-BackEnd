package com.backend.desafio.criptografia.dto;

import com.backend.desafio.criptografia.entity.transactionEntity;

public record transactionResponse(Long id,
                                  String userDocument,
                                  String creditCardToken,
                                  Long value) {
    public static transactionResponse fromEntity(transactionEntity entity){
        return new transactionResponse(
                entity.getTransactionId(),
                entity.getRawUserDocument(),
                entity.getRawCreditCardToken(),
                entity.getTransactionValue()
        );
    }
}
