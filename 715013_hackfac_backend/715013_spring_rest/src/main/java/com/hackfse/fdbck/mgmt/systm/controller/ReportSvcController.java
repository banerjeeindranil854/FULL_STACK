package com.hackfse.fdbck.mgmt.systm.controller;

import java.io.IOException;

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
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachXlRspVo;
import com.hackfse.fdbck.mgmt.systm.svc.impl.EvtSvcImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ReportSvcController {
	
	@Autowired
	private EvtSvcImpl evtSvcImpl;
	
	
	@ApiOperation(nickname = "getAllEvtRprt", value = "This API get report of all the events")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/getAllEvtRprt", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN, AppConstants.ROLE_PMO})
	public  ResponseEntity<OutReachXlRspVo> getAllEvtRprt(@RequestParam("path") String path,@RequestParam(value ="associateEmpId",required = false) String associateEmpId) throws IOException  {
		
		return ResponseEntity.ok().body(evtSvcImpl.findAllEvtRprt(path,associateEmpId));
	}
	
	@ApiOperation(nickname = "getindEvtRprt", value = "This API get report of all the events")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/getindEvtRprt", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_POC})
	public  ResponseEntity<OutReachXlRspVo> getindEvtRprt(@RequestParam("empId") String empId,@RequestParam("path") String path,@RequestParam(value ="associateEmpId",required = false) String associateEmpId) throws IOException  {
		
		return ResponseEntity.ok().body(evtSvcImpl.indEvtRprt(empId,path,associateEmpId));
	}
}
