package com.yuvintech.spring.boot.mobile.service;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yuvintech.msk.common.dto.MobileDto;
import com.yuvintech.msk.common.dto.Response;
import com.yuvintech.msk.common.dto.SaveMobileDto;
import com.yuvintech.msk.common.entity.LineOfBusiness;
import com.yuvintech.msk.common.entity.Mobile;
import com.yuvintech.msk.common.entity.Status;
import com.yuvintech.spring.boot.mobile.exception.MobileNotFoundException;
import com.yuvintech.spring.boot.mobile.repository.MobileRepository;

@SpringBootTest(classes = MobileServiceImpl.class)
public class MobileServiceTest {

	
	@MockBean
	private MobileRepository mobileRepository;
	
	@Autowired
	private MobileService mobileService;
	
	@Test
	public void testGetMobileById() {
		 when(mobileRepository.findById(1)).thenReturn(mockOptionalMobile());
		 Response<MobileDto> response = mobileService.getMobileById(1);
		 Assertions.assertNotNull(response);
		 Assertions.assertNotNull(response.getResponse());
		 Assertions.assertEquals("Motorola", response.getResponse().getName());
		 Assertions.assertEquals(Status.AVAILABLE.toString(), response.getResponse().getStatus());
		 Assertions.assertEquals(LineOfBusiness.ONLINE.toString(), response.getResponse().getLineOfBusiness());
	}
	
	
	@Test
	public void testGetMobileByIdWhenDBDoesnotReturnData() {
		 when(mobileRepository.findById(1)).thenReturn(null);
		 Assertions.assertThrows(NullPointerException.class, () -> mobileService.getMobileById(1));
	}
	
	
	@Test
	public void testGetMobileByIdWhenDBReturnsEmptyOptional() {
		 when(mobileRepository.findById(1)).thenReturn(Optional.empty());
		 MobileNotFoundException exception=	 Assertions.assertThrows(MobileNotFoundException.class, () -> mobileService.getMobileById(1));
		 Assertions.assertEquals("Mobile Not Found with given MObile Id", exception.getMessage());
	}
	
	
	@Test
	public void testSaveMobileVoid() {
		mobileService.saveMobileVoid(mockSaveMobileDto());
		verify(mobileRepository).save(mockSaveMobile().get());
	}
	
	
	
	private SaveMobileDto mockSaveMobileDto() {
		return SaveMobileDto
				.builder()
				.accessoryType("ALL")
				.countryCode("USA")
				.lineOfBusiness(LineOfBusiness.ONLINE.name())
				.status(Status.AVAILABLE.name())
				.name("OnePlus")
				.price(55000)
				.build();
		
	}
	

	private Optional<Mobile> mockSaveMobile() {
		return Optional.of(Mobile.
				builder()
				.name("OnePlus")
				.countryCode("USA")
				.price(55000.0)
				.status(Status.AVAILABLE)
				.lineOfBusiness(LineOfBusiness.ONLINE)
				.publicationDate(LocalDate.now())
				.accessoryType("ALL")
				.build());
	}
	
	private Optional<Mobile> mockOptionalMobile() {
		return Optional.of(Mobile.
				builder()
				.id(1)
				.name("Motorola")
				.countryCode("USA")
				.price(10000.0)
				.status(Status.AVAILABLE)
				.lineOfBusiness(LineOfBusiness.ONLINE)
				.publicationDate(LocalDate.now())
				.build());
	}
}
