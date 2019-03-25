package com.hackfse.fdbck.mgmt.systm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackfse.fdbck.mgmt.systm.cnst.AppConstants;
import com.hackfse.fdbck.mgmt.systm.res.vo.ErrorResponse;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachAllEvtRprtRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachEventPmoRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachEventSummeryRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachRegisteredRspVo;
import com.hackfse.fdbck.mgmt.systm.svc.impl.EvtSvcImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EvtSvcController {
	
	@Autowired
	private EvtSvcImpl evtSvcImpl;
	
	
	@ApiOperation(nickname = "findEvtSummry", value = "This API is retrieve Event Summary details against an event ID", response = OutReachEventSummeryRspVo.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OutReachEventSummeryRspVo.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })
	
	@PostMapping(value = "/findEvtSummry", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public ResponseEntity<OutReachEventSummeryRspVo> findEvtSummry(@RequestParam("eventId") String eventId) {
		final OutReachEventSummeryRspVo evntSummryVo = evtSvcImpl.findEvntSummry(eventId);
		return ResponseEntity.ok().body(evntSummryVo);
	}
	
	@ApiOperation(nickname = "findAllEvtSummry", value = "This API is retrieve all Event Summary details", response = OutReachEventSummeryRspVo.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OutReachEventSummeryRspVo.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/findAllEvtSummry", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public ResponseEntity<List<OutReachEventSummeryRspVo>> findAllEvtSummry() {
		final List<OutReachEventSummeryRspVo> evntSummryVoLst = evtSvcImpl.findAllEvtSummry();
		return ResponseEntity.ok().body(evntSummryVoLst);
	}
	
	@ApiOperation(nickname = "getEventPmos", value = "This API get all the event Pmo", response = OutReachEventPmoRspVo.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OutReachEventPmoRspVo.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/getEventPmos", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public  ResponseEntity<List<OutReachEventPmoRspVo>> getEventPmos()  {
		final List<OutReachEventPmoRspVo> statusRsp = evtSvcImpl.getEventPmos();
		return ResponseEntity.ok().body(statusRsp);
	}
	
}
