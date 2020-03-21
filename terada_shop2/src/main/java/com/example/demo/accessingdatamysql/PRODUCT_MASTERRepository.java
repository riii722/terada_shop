package com.example.demo.accessingdatamysql;


//import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PRODUCT_MASTERRepository extends CrudRepository<PRODUCT_MASTER, String> {
//	@Query("select a from PRODUCT_MASTER a where a.productCd like %:keyword% order by a.id asc")
//	List<PRODUCT_MASTER> findSYOHINNAME(@Param("keyword") String keyword);

}
