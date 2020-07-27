package com.yuvintech.spring.boot.mobile.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.yuvintech.spring.boot.mobile.dto.FilterDto;
import com.yuvintech.spring.boot.mobile.entity.LineOfBusiness;
import com.yuvintech.spring.boot.mobile.entity.Mobile;
import com.yuvintech.spring.boot.mobile.entity.Status;
import com.yuvintech.spring.boot.mobile.exception.MobileNotFoundException;
import com.yuvintech.spring.boot.mobile.repository.MobileRepository;


@Service
public class MobileServiceImpl implements MobileService {
	
	
	@Autowired
	private MobileRepository mobileRepository;
	
	
	
	@Override
	public List<Mobile> getAllMobiles(FilterDto filterDto) {
		
		final Double priceD  = filterDto.getPrice() <=0.0 ?   null : filterDto.getPrice() ;
		
		final Status statusE = !StringUtils.isEmpty(filterDto.getStatus()) ?  Status.valueOf(filterDto.getStatus()) : null;
		
		final LineOfBusiness lobE = !StringUtils.isEmpty(filterDto.getLob()) ?  LineOfBusiness.valueOf(filterDto.getLob()) : null;
		
		
		Specification<Mobile> filters =  createFilter("name",filterDto.getName())
													.and(createFilter("price",priceD ))			
													.and(createFilter("status",statusE ))
													.and( createFilter("lineOfBusiness",lobE ));	
		return mobileRepository.findAll(filters);
		
		
		//@Query - Place Holder : Case -1
				/*Integer statusInt =  statusE != null ? statusE.getValue() : null;
				Integer lobInt =  lobE != null ? lobE.getValue() : null;
				return mobileRepository.findByFiltersWithPlaceHolderQuery(name, priceD , statusInt, lobInt);
				*/
				
				
				//@Query With Named Parameter  - Case -2
				//return mobileRepository.findByFiltersWithNamedParameterQuery(name, priceD, statusE, lobE);
				
				
				//@Query With Native Query
				/*Integer statusInt =  statusE != null ? statusE.getValue() : null;
				Integer lobInt =  lobE != null ? lobE.getValue() : null;
				return mobileRepository.findByFilterWithNativeQuery(name, priceD, statusInt, lobInt);
				*/
		
	}

	@SuppressWarnings("serial")
	private Specification<Mobile> createFilter(String propertyName, Object value){		
		
		return  new Specification<Mobile>() {
				@Override
				public Predicate toPredicate(Root<Mobile> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
					
					
					if(value == null)
						return null;		
					if(value  instanceof String && StringUtils.isEmpty((String)value))
						return null;		
					
					if("price".equalsIgnoreCase(propertyName))
						return criteriaBuilder.le(root.get(propertyName), (Number)value);
					
					return criteriaBuilder.equal(root.get(propertyName), value);
				}
			};
	}
	
	
	
	
	
	@Override
	public Mobile getMobileById(int mobileId) {
		
	Optional<Mobile>	mobile = mobileRepository.findById(mobileId);
	
	mobile.orElseThrow(() ->  new MobileNotFoundException("Mobile Not Found with given MObile Id"));
	
	return mobile.get();
	
	}

	@Transactional
	@Override
	public List<Mobile> saveMobile(Mobile mobile) {
		mobile.setPublicationDate(LocalDate.now());
		mobileRepository.save(mobile); // insert
		return mobileRepository.findAll();
	}

	@Transactional
	@Override
	public Mobile updateMobile(Mobile mobile, int mobileId) {
		getMobileById(mobileId);
		mobile.setId(mobileId);
		mobileRepository.save(mobile);//update
		return mobile;
	}

	@Transactional
	@Override
	public void deleteMobile(int mobileId) {
		mobileRepository.deleteById(mobileId);
	}

	
	
}
