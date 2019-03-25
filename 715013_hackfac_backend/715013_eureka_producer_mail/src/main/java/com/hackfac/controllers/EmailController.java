package com.hackfac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackfac.controllers.impl.EvtSvcImpl;

@RestController
public class EmailController {
    @Autowired
    private EvtSvcImpl evtSvcImpl;
	@GetMapping(value = "/sendMail", produces = { "application/json" })
	public  ResponseEntity<?> sendMail()  {
		evtSvcImpl.sendEmail();
	 return ResponseEntity.ok().body("email send successfull");
	}

}