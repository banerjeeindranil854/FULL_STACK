package com.hackfac.rowmapper;

import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

import com.hackfac.model.OutReachEventSummeryDTO;

public class EventSummeryRowmapper implements RowMapper<OutReachEventSummeryDTO>{

	
	@Override
	public OutReachEventSummeryDTO mapRow(RowSet rs) throws Exception {
		if (rs == null || rs.getCurrentRow() == null) {
            return null;
        }
		OutReachEventSummeryDTO outReachEventSummeryDTO=new OutReachEventSummeryDTO();
		outReachEventSummeryDTO.setEventId(rs.getColumnValue(0));
		outReachEventSummeryDTO.setMonth(rs.getColumnValue(1));
		outReachEventSummeryDTO.setBaseLocation(rs.getColumnValue(2));
		outReachEventSummeryDTO.setBeneficiaryName(rs.getColumnValue(3));
		outReachEventSummeryDTO.setVenueAddress(rs.getColumnValue(4));
		outReachEventSummeryDTO.setCouncilName(rs.getColumnValue(5));
		outReachEventSummeryDTO.setProject(rs.getColumnValue(6));
		outReachEventSummeryDTO.setCategory(rs.getColumnValue(7));
		outReachEventSummeryDTO.setEventName(rs.getColumnValue(8));
		outReachEventSummeryDTO.setEventDescription(rs.getColumnValue(9));
		outReachEventSummeryDTO.setEventDate(rs.getColumnValue(10));
		outReachEventSummeryDTO.setTotalVolunteer(rs.getColumnValue(11));
		outReachEventSummeryDTO.setTotalVolunteerHour(rs.getColumnValue(12));
		outReachEventSummeryDTO.setTotalTravleHoures(rs.getColumnValue(13));
		outReachEventSummeryDTO.setOverallVolunteerHours(rs.getColumnValue(14));
		return outReachEventSummeryDTO;
	}

}
