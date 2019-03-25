package com.hackfac.controllers.impl;

import org.springframework.stereotype.Service;

import com.hackfac.controllers.cnfg.MailConfig;


@Service
public class EvtSvcImpl {


	public void sendEmail() {
		MailConfig mailConfig = new MailConfig();
		mailConfig.sendMail();
	}

}