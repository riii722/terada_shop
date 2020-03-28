package com.example.demo.product_master;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PRODUCTRepositoryCustomImpl implements PRODUCT_MASTERRepository {
	@Autowired
	EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<PRODUCT_MASTER> search(String productCd, String syohinName) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p From PRODUCT_MASTER p WHERE ");
		boolean andFlg = false;
		boolean productCdFlg = false;
		if (!"".equals(productCd) && productCd != null) {
			sql.append(" p.productCd LIKE :productCd ");
			productCdFlg = true;
			andFlg = true;
		}
		boolean syohinNameFlg = false;
		if (!"".equals(syohinName) && syohinName != null) {
			if (andFlg) sql.append(" AND ");
			sql.append("p.syohinName LIKE :syohinName");
			syohinNameFlg = true;
			andFlg = true;
		}
		Query query = manager.createQuery(sql.toString());
		if (productCdFlg) query.setParameter("productCd", "%" + productCd + "%");
		if (syohinNameFlg) query.setParameter("syohinName", "%" + syohinName + "%");
		return query.getResultList();
		}

	@Override
	public <S extends PRODUCT_MASTER> S save(S entity) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public <S extends PRODUCT_MASTER> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Optional<PRODUCT_MASTER> findById(String id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public Iterable<PRODUCT_MASTER> findAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Iterable<PRODUCT_MASTER> findAllById(Iterable<String> ids) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public long count() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(PRODUCT_MASTER entity) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteAll(Iterable<? extends PRODUCT_MASTER> entities) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteAll() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
