package com.example.demo.product_master;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PRODUCT_MASTERRepository extends CrudRepository<PRODUCT_MASTER, String> {
	public List<PRODUCT_MASTER> search(String PRODUCTCD, String SYOHINNAME);

}
