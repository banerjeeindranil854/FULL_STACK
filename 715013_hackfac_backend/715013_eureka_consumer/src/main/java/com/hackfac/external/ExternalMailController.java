package com.hackfac.external;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.hackfac.controllers.ConsumerControllerClient;

@RestController
public class ExternalMailController {
	@Autowired
	ConsumerControllerClient consumerControllerClient;
	@RequestMapping(value = "/1", method = RequestMethod.GET)
	public String externalMailClient() throws RestClientException, IOException {

		return consumerControllerClient.getMail();
	}

}