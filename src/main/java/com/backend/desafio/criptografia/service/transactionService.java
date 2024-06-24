package com.backend.desafio.criptografia.service;

import com.backend.desafio.criptografia.dto.createTransactionRequest;
import com.backend.desafio.criptografia.dto.transactionResponse;
import com.backend.desafio.criptografia.entity.transactionEntity;
import com.backend.desafio.criptografia.repository.transactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class transactionService {

    private final transactionRepository repository;

    public transactionService(transactionRepository repository) {
        this.repository = repository;
    }

    public void create(createTransactionRequest resquest){
        var entity = new transactionEntity();
        entity.setRawCreditCardToken(resquest.creditCardToken());
        entity.setRawUserDocument(resquest.userDocument());
        entity.setTransactionValue(resquest.value());

        repository.save(entity);
    }

    public Page<transactionResponse> listAll(int page, int pageSize){
      var content =  repository.findAll(PageRequest.of(page, pageSize));

      return content.map(transactionResponse::fromEntity);
    }
}
