package com.hackfac.processoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.hackfac.config.MailConfig;
import com.hackfac.model.OutReachNotRegisteredDTO;

public class OutReachNotRegisteredProcessor implements ItemProcessor<OutReachNotRegisteredDTO, OutReachNotRegisteredDTO>{
	private static final Logger log = LoggerFactory.getLogger(OutReachNotRegisteredProcessor.class);
	@Override
    public OutReachNotRegisteredDTO process(final OutReachNotRegisteredDTO outReachNotRegisteredDTO) throws Exception {
    	
    	final String eventId = outReachNotRegisteredDTO.getEventId();
        final String eventName = outReachNotRegisteredDTO.getEventName();
        final String beneficiaryName = outReachNotRegisteredDTO.getBeneficiaryName();
        final String baseLocation = outReachNotRegisteredDTO.getBaseLocation();
        final String eventDate = outReachNotRegisteredDTO.getEventDate();
        final String empId = outReachNotRegisteredDTO.getEmpId();
        final OutReachNotRegisteredDTO transformedOutReachNotRegisteredDTO = new OutReachNotRegisteredDTO(eventId, eventName, beneficiaryName,baseLocation,eventDate,empId);
        MailConfig mailConfig=new MailConfig();
        mailConfig.sendMail(empId,"N");
        log.info("Converting ({}) into ({})",outReachNotRegisteredDTO,transformedOutReachNotRegisteredDTO);

        return transformedOutReachNotRegisteredDTO;
    }
	
}
