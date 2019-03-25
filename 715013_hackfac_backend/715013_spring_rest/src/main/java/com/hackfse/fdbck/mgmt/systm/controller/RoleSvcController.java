package com.hackfse.fdbck.mgmt.systm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackfse.fdbck.mgmt.systm.cnst.AppConstants;
import com.hackfse.fdbck.mgmt.systm.res.vo.ErrorResponse;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachEventRoleRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachRegisteredRspVo;
import com.hackfse.fdbck.mgmt.systm.svc.impl.EvtSvcImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RoleSvcController {
	
	@Autowired
	private EvtSvcImpl evtSvcImpl;
	
	
	@ApiOperation(nickname = "addRole", value = "This API Add role maching with the LDAP",response = OutReachEventRoleRspVo.class, responseContainer = "Object")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK",response = OutReachEventRoleRspVo.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/addRole", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public  ResponseEntity<OutReachEventRoleRspVo> addRole(@RequestParam("empRole") String empRole,@RequestParam("empId") String empId)  {
		evtSvcImpl.addRole( empId,empRole);
		return ResponseEntity.ok().body(evtSvcImpl.addRole( empId,empRole));
	}
	
	@ApiOperation(nickname = "updateRole", value = "This API update role maching with the LDAP",response = OutReachEventRoleRspVo.class, responseContainer = "Object")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK",response = OutReachEventRoleRspVo.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PutMapping(value = "/updateRole", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public  ResponseEntity<OutReachEventRoleRspVo> updateRole(@RequestParam("empRole") String empRole,@RequestParam("empId") String empId)  {
		evtSvcImpl.updatRole( empId,empRole);
		return ResponseEntity.ok().body(evtSvcImpl.updatRole( empId,empRole));
	}
	
	@ApiOperation(nickname = "deleteRole", value = "This API delete role maching with the LDAP")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PutMapping(value = "/deleteRole", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public  ResponseEntity<?> deleteRole(@RequestParam("empId") String empId)  {
		evtSvcImpl.deleteRole( empId);
		return  new ResponseEntity(HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "getAllRoles", value = "This API get all the event Pmo", response = OutReachEventRoleRspVo.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OutReachEventRoleRspVo.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	
	@PostMapping(value = "/getAllRoles", produces = { "application/json;charset=UTF-8" })
	@Secured({AppConstants.ROLE_ADMIN})
	public  ResponseEntity<List<OutReachEventRoleRspVo>> getAllRoles()  {
		final List<OutReachEventRoleRspVo> statusRsp = evtSvcImpl.getAllRole();
		return ResponseEntity.ok().body(statusRsp);
	}

}
