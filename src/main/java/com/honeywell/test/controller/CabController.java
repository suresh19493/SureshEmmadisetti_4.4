package com.honeywell.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honeywell.test.Util.ResponseUtil;
import com.honeywell.test.model.ApiResponse;
import com.honeywell.test.model.Cab;
import com.honeywell.test.model.Person;
import com.honeywell.test.service.CabService;

@RestController
@RequestMapping(value = "/cab")
public class CabController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CabController.class);

	@Autowired
	private CabService cabServcie;
	@Autowired
	private ResponseUtil responseUtil;

	@PostMapping("/book")
	public ResponseEntity<ApiResponse> getCabNearestMe(@RequestBody Person person) throws Exception {
		try {
			LOGGER.info("person : {}", person);
			Cab cab = cabServcie.getCabNearestMe(person);
			return new ResponseEntity<ApiResponse>(responseUtil.getSuccessResponse(cab), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			throw e;
		}
	}
}
