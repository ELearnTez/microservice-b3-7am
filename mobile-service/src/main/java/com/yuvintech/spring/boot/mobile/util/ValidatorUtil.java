package com.yuvintech.spring.boot.mobile.util;

import java.util.ArrayList;
import java.util.List;

import com.yuvintech.msk.common.dto.ErrorDetails;
import com.yuvintech.msk.common.dto.SaveMobileDto;
import com.yuvintech.msk.common.entity.LineOfBusiness;
import com.yuvintech.msk.common.entity.Status;
import com.yuvintech.spring.boot.mobile.exception.InvalidInputException;

public class ValidatorUtil {

	public static void valdate(SaveMobileDto smd) {

		List<ErrorDetails> errors = new ArrayList<>();

		try {
			Status.valueOf(smd.getStatus());
		} catch (IllegalArgumentException e) {
			errors.add(ErrorDetails.builder().code(1010).message("Invalid Input For Status :: " + smd.getStatus()).build());
		}

		try {
			LineOfBusiness.valueOf(smd.getLineOfBusiness());
		} catch (IllegalArgumentException e) {
			errors.add(ErrorDetails.builder().code(1010).message("Invalid Input for Line Of Business " + smd.getLineOfBusiness())
					.build());
		}

		if (errors.size() > 0) {
			throw new InvalidInputException("Request is Invalid", errors);
		}
	}

}
