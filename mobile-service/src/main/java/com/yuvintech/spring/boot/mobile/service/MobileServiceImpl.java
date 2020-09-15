package com.yuvintech.spring.boot.mobile.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.yuvintech.msk.common.dto.FilterDto;
import com.yuvintech.msk.common.dto.MobileDto;
import com.yuvintech.msk.common.dto.Response;
import com.yuvintech.msk.common.dto.SaveMobileDto;
import com.yuvintech.msk.common.entity.LineOfBusiness;
import com.yuvintech.msk.common.entity.Mobile;
import com.yuvintech.msk.common.entity.Status;
import com.yuvintech.spring.boot.mobile.exception.MobileNotFoundException;
import com.yuvintech.spring.boot.mobile.repository.MobileRepository;


@Service
public class MobileServiceImpl implements MobileService {
	
	
	@Autowired
	private MobileRepository mobileRepository;
	
	
	
	@Override
	public Response<List<MobileDto>> getAllMobiles(FilterDto filterDto) {
		
		final Double priceD  = filterDto.getPrice() <=0.0 ?   null : filterDto.getPrice() ;
		
		final Status statusE = !StringUtils.isEmpty(filterDto.getStatus()) ?  Status.valueOf(filterDto.getStatus()) : null;
		
		final LineOfBusiness lobE = !StringUtils.isEmpty(filterDto.getLob()) ?  LineOfBusiness.valueOf(filterDto.getLob()) : null;
		
		
		Specification<Mobile> filters =  createFilter("name",filterDto.getName())
													.and(createFilter("price",priceD ))			
													.and(createFilter("status",statusE ))
													.and( createFilter("lineOfBusiness",lobE ));	
		List<MobileDto> mobileList =  mobileRepository.findAll(filters)
		 				.stream()
		 				.map(entity -> enityToDTO(entity))
		 				.collect(Collectors.toList());
		
		return Response.<List<MobileDto>>builder().response(mobileList).build();
		
		
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
	public  Response<MobileDto> getMobileById(int mobileId) {
		
	Optional<Mobile> optionalMobile = mobileRepository.findById(mobileId);
	
	optionalMobile.orElseThrow(() ->  new MobileNotFoundException("Mobile Not Found with given MObile Id"));
	
	MobileDto mobileDto =  enityToDTO(optionalMobile.get());
	
	return Response.<MobileDto>builder().response(mobileDto).build();
	
	
	}

	@Transactional
	@Override
	public Response<List<MobileDto>> saveMobile(SaveMobileDto dto) {
		String accessoryType = StringUtils.isEmpty(dto.getAccessoryType()) ? "ALL": dto.getAccessoryType();
				
		Mobile mobile = Mobile
				             .builder()
				             .name(dto.getName())
				             .countryCode(dto.getCountryCode())
				             .price(dto.getPrice())
				             .accessoryType(accessoryType)
				             .publicationDate(LocalDate.now())
				             .status(Status.valueOf(dto.getStatus()))
				             .lineOfBusiness(LineOfBusiness.valueOf(dto.getLineOfBusiness()))
				             .build();
		
		mobile.setPublicationDate(LocalDate.now());
		mobileRepository.save(mobile); // insert
		List<MobileDto> mobileList =  mobileRepository.findAll()
				               .stream()
				               .map(entity -> enityToDTO(entity))
				               .collect(Collectors.toList());
		
		return Response.<List<MobileDto>>builder().response(mobileList).build();
	}

	@Transactional
	@Override
	public Response<MobileDto> updateMobile(MobileDto mobileDto, int mobileId) {
		Mobile mobile = dtoToEntity(mobileDto);
		getMobileById(mobileId);
		mobile.setId(mobileId);
		Mobile dbmobile = mobileRepository.save(mobile);//update
		MobileDto md = enityToDTO(dbmobile);
		return Response.<MobileDto>builder().response(md).build();
	}

	@Transactional
	@Override
	public Response<Void> deleteMobile(int mobileId) {
		mobileRepository.deleteById(mobileId);
		return Response.<Void>builder().build();
	}
	
	private Mobile dtoToEntity(MobileDto dto) {
		return Mobile
				.builder()
				.id(dto.getId())
				.name(dto.getName())
				.countryCode(dto.getCountryCode())
				.status(Status.valueOf(dto.getStatus()))
				.lineOfBusiness(LineOfBusiness.valueOf(dto.getLineOfBusiness()))
				.publicationDate(dto.getPublicationDate())
				.price(dto.getPrice())
				.accessoryType(dto.getAccessoryType())
				.build();
	}

	private MobileDto enityToDTO(Mobile entity) {
		
		return MobileDto.builder()
				        .id(entity.getId())
				        .accessoryType(entity.getAccessoryType())
				        .price(entity.getPrice())
				        .countryCode(entity.getCountryCode())
				        .status(entity.getStatus().name())
				        .lineOfBusiness(entity.getLineOfBusiness().name())
				        .name(entity.getName())
				        .publicationDate(entity.getPublicationDate())
				        .build();
		
	}
	
	
	public void saveMobileVoid(SaveMobileDto dto) {
		String accessoryType = StringUtils.isEmpty(dto.getAccessoryType()) ? "ALL": dto.getAccessoryType();
		// void
		
		Mobile mobile = Mobile
				             .builder()
				             .name(dto.getName())
				             .countryCode(dto.getCountryCode())
				             .price(dto.getPrice())
				             .accessoryType(accessoryType)
				             .publicationDate(LocalDate.now())
				             .status(Status.valueOf(dto.getStatus()))
				             .lineOfBusiness(LineOfBusiness.valueOf(dto.getLineOfBusiness()))
				             .build();
		
		mobile.setPublicationDate(LocalDate.now());
		mobileRepository.save(mobile); // insert
		
	}
	
}
