package com.example.demo.product_master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	PRODUCT_MASTERRepository productMasterRepository;
	@Autowired
	PRODUCTRepositoryCustomImpl productRepositoryCustom;

	public Iterable<PRODUCT_MASTER> search(String productCd, String syohinName) {
		Iterable<PRODUCT_MASTER> result;
		if ("".equals(productCd) && "".equals(syohinName)) {
			result = productMasterRepository.findAll();
		} else {
			result = productRepositoryCustom.search(productCd, syohinName);
		}
		return result;
	}
}
