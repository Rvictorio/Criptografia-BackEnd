package com.backend.desafio.criptografia.controller;

import com.backend.desafio.criptografia.dto.createTransactionRequest;
import com.backend.desafio.criptografia.dto.transactionResponse;
import com.backend.desafio.criptografia.service.transactionService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/transactions")
public class criptografiaController {

    private final transactionService service;

    public criptografiaController(transactionService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody createTransactionRequest request){
        service.create(request);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Page<transactionResponse>> listAll(@RequestParam(name = "page", defaultValue = "0")Integer page,
                                                             @RequestParam(name = "pageSize", defaultValue = "10")Integer pageSize){
        var body = service.listAll(page, pageSize);
        return ResponseEntity.ok(body);
    }
}
