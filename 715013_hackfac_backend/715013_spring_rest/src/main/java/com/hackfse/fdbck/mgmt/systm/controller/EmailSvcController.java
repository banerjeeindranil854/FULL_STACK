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
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachEventInfoRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachEventRoleRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachNotRegisteredRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachRegisteredRspVo;
import com.hackfse.fdbck.mgmt.systm.svc.impl.EvtSvcImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmailSvcController {
	
	@Autowired
	private EvtSvcImpl evtSvcImpl;
	
	
	@ApiOperation(nickname = "findAllEmpAttndAnEvt", value = "This API retrives records of volunteers attended an event", response = OutReachEventInfoRspVo.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OutReachEventInfoRspVo.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/findAllEmpAttndAnEvt", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public ResponseEntity<List<OutReachEventInfoRspVo>> findAllEmpAttndAnEvt() {
		final List<OutReachEventInfoRspVo> evntInfoRsp = evtSvcImpl.findAllEmpInAnEvt();
		return ResponseEntity.ok().body(evntInfoRsp);
	}
	
	
	@ApiOperation(nickname = "findAllVolUnrgstrdEvt", value = "This API retrives records of volunteers degistered from event", response = OutReachNotRegisteredRspVo.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OutReachNotRegisteredRspVo.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/findAllVolUnrgstrdEvt", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public ResponseEntity<List<OutReachNotRegisteredRspVo>> findAllVolUnrgstrdEvt() {
		final List<OutReachNotRegisteredRspVo> evntInfoRsp = evtSvcImpl.findAllUnrgstrd();
		return ResponseEntity.ok().body(evntInfoRsp);
	}
	
	
	@ApiOperation(nickname = "findAllVolentierSendTheResponse", value = "This API retrives records of volunteers degistered from event", response = OutReachRegisteredRspVo.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OutReachRegisteredRspVo.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/findAllVolentierSendTheResponse", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public ResponseEntity<List<OutReachRegisteredRspVo>> findAllVolUnattndedEvt()  {
		final List<OutReachRegisteredRspVo> evntInfoRsp = evtSvcImpl.findAllUnattnd();
		return ResponseEntity.ok().body(evntInfoRsp);
	}
	
		
	@ApiOperation(nickname = "sendMail", value = "This Api send Mails")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/sendMail", produces = { "application/json;charset=UTF-8" })
	public  ResponseEntity<?> sendMail(@RequestParam("status") String status,@RequestParam("empId") String empId)  {
		evtSvcImpl.sendEmail(empId, status);
		return  new ResponseEntity(HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "findAllNotSendedResponse", value = "All who did not give response", response = OutReachRegisteredRspVo.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OutReachRegisteredRspVo.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/findAllNotSendedResponse", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public ResponseEntity<List<OutReachRegisteredRspVo>> findAllNotSendedResponse()  {
		final List<OutReachRegisteredRspVo> evntInfoRsp = evtSvcImpl.findAllNotSendedResponse();
		return ResponseEntity.ok().body(evntInfoRsp);
	}
}
