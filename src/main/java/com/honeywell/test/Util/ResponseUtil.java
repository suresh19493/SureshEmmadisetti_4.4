package com.honeywell.test.Util;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.honeywell.test.model.APIStatus;
import com.honeywell.test.model.ApiResponse;

@Component
public class ResponseUtil {
	public ApiResponse getSuccessResponse(Object payload) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStatus(APIStatus.SUCCESS);
		apiResponse.setPayload(payload);
		return apiResponse;
	}

	public ApiResponse getErrorResponse(Exception ex, HttpStatus errorStatus) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStatus(APIStatus.ERROR);
		apiResponse.setErrorMessage(ex.getMessage());
		apiResponse.setErrorCode(errorStatus.value());
		return apiResponse;
	}
}
