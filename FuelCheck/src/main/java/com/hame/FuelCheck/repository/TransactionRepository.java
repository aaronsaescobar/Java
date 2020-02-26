package com.hame.FuelCheck.repository;

import org.springframework.data.repository.CrudRepository;

import com.hame.FuelCheck.entity.TransactionEntity;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {

}
