package com.backend.desafio.criptografia.repository;

import com.backend.desafio.criptografia.entity.transactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transactionRepository extends JpaRepository<transactionEntity, Long> {

}
