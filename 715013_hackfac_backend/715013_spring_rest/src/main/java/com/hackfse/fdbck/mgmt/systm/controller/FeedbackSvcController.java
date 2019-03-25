package com.hackfse.fdbck.mgmt.systm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackfse.fdbck.mgmt.systm.cnst.AppConstants;
import com.hackfse.fdbck.mgmt.systm.res.vo.ErrorResponse;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachRegisteredRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachStatusRspVo;
import com.hackfse.fdbck.mgmt.systm.svc.impl.EvtSvcImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FeedbackSvcController {
	
	@Autowired
	private EvtSvcImpl evtSvcImpl;
	
	
		
	@ApiOperation(nickname = "addFedback", value = "This API Add feedback for any event and user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/addFeedBack", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN,AppConstants.ROLE_EMP})
	public  ResponseEntity<?> addFedback(@RequestParam("eventId") String eventId,@RequestParam("empId") String empId,@RequestParam("rating") String rating,@RequestParam("description") String description)  {
		evtSvcImpl.addFedback(eventId, empId, rating, description);
		return  new ResponseEntity(HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "updateFedback", value = "This API update feedback for any event and user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/updateFedback", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public  ResponseEntity<?> updateFedback(@RequestParam("eventId") String eventId,@RequestParam("empId") String empId,@RequestParam("rating") String rating,@RequestParam("description") String description)  {
		evtSvcImpl.addFedback(eventId, empId, rating, description);
		return  new ResponseEntity(HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "deleteFedback", value = "This API delete feedback for any event and user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/deleteFedback", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public  ResponseEntity<?> deleteFedback(@RequestParam("eventId") String eventId,@RequestParam("empId") String empId,@RequestParam("rating") String rating,@RequestParam("description") String description)  {
		evtSvcImpl.deleteFeedBack(eventId, empId, rating, description);
		return  new ResponseEntity(HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "getFeedbacks", value = "This API get all the feed back", response = OutReachStatusRspVo.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OutReachStatusRspVo.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/getFeedbacks", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public  ResponseEntity<List<OutReachStatusRspVo>> getFeedbacks()  {
		final List<OutReachStatusRspVo> statusRsp = evtSvcImpl.getFedbacks();
		return ResponseEntity.ok().body(statusRsp);
	}
	
}
