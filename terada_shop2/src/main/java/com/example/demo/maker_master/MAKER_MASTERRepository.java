package com.example.demo.maker_master;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MAKER_MASTERRepository extends CrudRepository<MAKER_MASTER, String> {
	public List<MAKER_MASTER> search(String MAKERCD);

}
