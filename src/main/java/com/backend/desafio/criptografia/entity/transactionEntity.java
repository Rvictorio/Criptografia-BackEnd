package com.backend.desafio.criptografia.entity;

import com.backend.desafio.criptografia.service.cryptoService;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_transactions")
public class transactionEntity {

    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "user_document")
    private String encryptedUserDocument;

    @Column(name = "credit_card_token")
    private String encryptedCreditCardToken;

    @Column(name = "transaction_value")
    private Long transactionValue;

    @Transient
    private String rawUserDocument;

    @Transient
    private String rawCreditCardToken;

    public transactionEntity() {
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getEncryptedUserDocument() {
        return encryptedUserDocument;
    }

    public void setEncryptedUserDocument(String encryptedUserDocument) {
        this.encryptedUserDocument = encryptedUserDocument;
    }

    public String getEncryptedCreditCardToken() {
        return encryptedCreditCardToken;
    }

    public void setEncryptedCreditCardToken(String encryptedCreditCardToken) {
        this.encryptedCreditCardToken = encryptedCreditCardToken;
    }

    public Long getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(Long transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getRawUserDocument() {
        return rawUserDocument;
    }

    public void setRawUserDocument(String rawUserDocument) {
        this.rawUserDocument = rawUserDocument;
    }

    public String getRawCreditCardToken() {
        return rawCreditCardToken;
    }

    public void setRawCreditCardToken(String rawCreditCardToken) {
        this.rawCreditCardToken = rawCreditCardToken;
    }

    @PrePersist
    public void prePersist(){
        this.encryptedUserDocument =  cryptoService.encrypt(rawUserDocument);
        this.encryptedCreditCardToken =  cryptoService.encrypt(rawCreditCardToken);
    }

    @PostLoad
    public void postLoad(){
        this.rawUserDocument =  cryptoService.encrypt(encryptedUserDocument);
        this.rawCreditCardToken =  cryptoService.encrypt(encryptedCreditCardToken);
    }


}
