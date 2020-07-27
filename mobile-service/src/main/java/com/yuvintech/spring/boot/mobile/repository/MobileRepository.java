package com.yuvintech.spring.boot.mobile.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;

import com.yuvintech.spring.boot.mobile.entity.LineOfBusiness;
import com.yuvintech.spring.boot.mobile.entity.Mobile;
import com.yuvintech.spring.boot.mobile.entity.Status;


public interface MobileRepository extends JpaRepository<Mobile, Integer> , JpaSpecificationExecutor<Mobile>{
	
	@Transactional
	//Place Holder
	@Query(value = "select m from Mobile m " + 
			"    where (?1 is null or m.name = ?1)" + 
			"    and   (?2  is null or m.price = ?2)" + 
			"    and   (?3 is null or m.status = ?3)" + 
			"    and  (?4 is null or m.lineOfBusiness = ?4)")
	List<Mobile> findByFiltersWithPlaceHolderQuery(String name, Double price, Integer status, Integer lob);
	
	
	//Named Parameter
	@Query(value = "select m from Mobile m " + 
			"    where (:name is null or m.name = :name)" + 
			"    and   (:price  is null or m.price = :price)" + 
			"    and   (:status is null or m.status = :status)" + 
			"    and  (:lob is null or m.lineOfBusiness = :lob)")
	List<Mobile> findByFiltersWithNamedParameterQuery(String name, Double price, Status status, LineOfBusiness lob);
	
	
	// Native Query
	@Query(value=" select * from mobile m " + 
			"    where (:name is null or m.name = :name)" + 
			"    and   (:price is null or m.price = :price)" + 
			"    and   (:status is null or m.status = :status)" + 
			"    and  (:lob is null or m.line_of_business = :lob)", nativeQuery = true)
	List<Mobile> findByFilterWithNativeQuery(String name, Double price, Integer status, Integer lob);
	

}
