package com.backend.desafio.criptografia.dto;

public record createTransactionRequest(String userDocument,
                                       String creditCardToken,
                                       Long value) {
}
