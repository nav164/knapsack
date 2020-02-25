package com.assingment.controller;

import com.assingment.aspect.RequestResponseLogger;
import com.assingment.service.OptimizeWeightAndValueService;
import io.swagger.annotations.*;
import io.swagger.model.Error;
import io.swagger.model.WeightAndValue;
import io.swagger.model.WeightAndValueResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@CrossOrigin
@RestController
@Api(value="Optimize weight and value API")
@RequestMapping("/")
public class OptimizeWeightAndValue {

	private static final Logger log = LogManager.getLogger();

	private final OptimizeWeightAndValueService optimizeWeightAndValueService;

	public OptimizeWeightAndValue(OptimizeWeightAndValueService optimizeWeightAndValueService) {
		this.optimizeWeightAndValueService = optimizeWeightAndValueService;
	}

	@ApiOperation(value = "This method will take weight and value array and return array of optimized weight with total weight and value in allowed limit", nickname = "getOptimumWeightAndValue", notes = "This method will take weight and value array and return array of optimized weight with total weight and value in allowed limit", response = WeightAndValueResponse.class, tags={ "Optimize weight and value Services", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Return optimized array of weight alone with total weight and values", response = WeightAndValueResponse.class)})
	@PostMapping(value = "solve", produces = { "application/json", "application/stream+json", "text/event-stream" })
	@RequestResponseLogger
	public ResponseEntity<WeightAndValueResponse> getOptimumWeightAndValue(@ApiParam(value = "Weight and value request object") @Valid @RequestBody WeightAndValue weightAndValue){
		return ResponseEntity.ok(this.optimizeWeightAndValueService.getMaxValueAndWeightList(weightAndValue));
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Error> handleAllExceptions(Exception ex, WebRequest request) {
		Error errorDetails = new Error();
		errorDetails.setCode("500");
		errorDetails.setMessage("Internal Server Error. Please try again later.");
		log.error("Exception occured --> "+ ex);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
