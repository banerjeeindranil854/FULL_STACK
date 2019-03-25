package com.hackfac.processoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.hackfac.config.MailConfig;
import com.hackfac.model.OutReachRegisteredDTO;

public class OutReachRegisteredProcessor implements ItemProcessor<OutReachRegisteredDTO, OutReachRegisteredDTO>{
	private static final Logger log = LoggerFactory.getLogger(OutReachRegisteredProcessor.class);
	@Override
    public OutReachRegisteredDTO process(final OutReachRegisteredDTO outReachRegisteredDTO) throws Exception {
    	
    	final String eventId = outReachRegisteredDTO.getEventId();
        final String eventName = outReachRegisteredDTO.getEventName();
        final String beneficiaryName = outReachRegisteredDTO.getBeneficiaryName();
        final String baseLocation = outReachRegisteredDTO.getBaseLocation();
        final String eventDate = outReachRegisteredDTO.getEventDate();
        final String empId = outReachRegisteredDTO.getEmpId();
        final OutReachRegisteredDTO transformedOutReachRegisteredDTO = new OutReachRegisteredDTO(eventId, eventName, beneficiaryName,baseLocation,eventDate,empId);
        MailConfig mailConfig=new MailConfig();
        mailConfig.sendMail(empId,"R");
        log.info("Converting ({}) into ({})",outReachRegisteredDTO,transformedOutReachRegisteredDTO);

        return transformedOutReachRegisteredDTO;
    }
	
}
