package com.hackfac.processoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.hackfac.model.OutReachEventPmoDTO;

public class OutReachEventPmoProcessor implements ItemProcessor<OutReachEventPmoDTO, OutReachEventPmoDTO> {
	private static final Logger log = LoggerFactory.getLogger(OutReachEventPmoProcessor.class);

	@Override
	public OutReachEventPmoDTO process(final OutReachEventPmoDTO outReachEventPmoDTO) throws Exception {

		final String eventId = outReachEventPmoDTO.getEventId();
		final String empId = outReachEventPmoDTO.getEmpId();
		final OutReachEventPmoDTO transformedOutReachEventPmoDTO = new OutReachEventPmoDTO(eventId,empId);

		log.info("Converting ({}) into ({})",outReachEventPmoDTO,transformedOutReachEventPmoDTO);

		return transformedOutReachEventPmoDTO;
	}

}
