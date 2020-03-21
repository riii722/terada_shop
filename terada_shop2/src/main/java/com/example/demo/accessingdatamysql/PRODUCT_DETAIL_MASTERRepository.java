package com.example.demo.accessingdatamysql;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PRODUCT_DETAIL_MASTERRepository extends CrudRepository<PRODUCT_DETAIL_MASTER, String> {

}
