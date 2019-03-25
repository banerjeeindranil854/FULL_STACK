package com.hackfse.fdbck.mgmt.systm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackfse.fdbck.mgmt.systm.cnst.MessageConstants;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachEventRoleRspVo;
import com.hackfse.fdbck.mgmt.systm.security.ApiResponse;
import com.hackfse.fdbck.mgmt.systm.security.JwtTokenProvider;
import com.hackfse.fdbck.mgmt.systm.svc.impl.EvtSvcImpl;
import com.hackfse.fdbck.mgmt.systm.vo.JwtAuthenticationResponse;
import com.hackfse.fdbck.mgmt.systm.vo.LoginRequest;
import com.hackfse.fdbck.mgmt.systm.vo.ValidateTokenRequest;


@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    EvtSvcImpl evtSvcImpl;
    
    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody final LoginRequest loginRequest) {
    	int count=0;
    	if(loginRequest.getUsername().isEmpty() || loginRequest.getPassword().isEmpty()) {
    		 return new ResponseEntity(new ApiResponse(false, MessageConstants.UN_OR_PW_INVALID,""),
                     HttpStatus.BAD_REQUEST);
    	}
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        final String jwt = tokenProvider.generateToken(authentication);
        List<OutReachEventRoleRspVo> allRoles=evtSvcImpl.getAllRole();
        for(OutReachEventRoleRspVo allRole :allRoles) {
        	if(allRole.getEmpId().equals(loginRequest.getUsername())) {
        		count=count+1;
        	}
        }
        if(count==0) {
        evtSvcImpl.addRole(loginRequest.getUsername(),"");
        }
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/validatetoken")
    public ResponseEntity<?> getTokenByCredentials(@Valid @RequestBody ValidateTokenRequest validateToken) {
    	 String username = null;
    	 String jwt =validateToken.getToken();
         if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                username = tokenProvider.getUsernameFromJWT(jwt);
             return ResponseEntity.ok(new ApiResponse(Boolean.TRUE,username,evtSvcImpl.getRole(username).getEmpRole()));
           }else {
        	   return new ResponseEntity(new ApiResponse(false, MessageConstants.INVALID_TOKEN, ""),
                       HttpStatus.BAD_REQUEST);
           }
         
    }
}