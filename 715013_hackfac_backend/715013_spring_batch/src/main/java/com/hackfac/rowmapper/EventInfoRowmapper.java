package com.hackfac.rowmapper;

import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

import com.hackfac.model.OutReachEventInfoDTO;

public class EventInfoRowmapper implements RowMapper<OutReachEventInfoDTO>{

	
	@Override
	public OutReachEventInfoDTO mapRow(RowSet rs) throws Exception {
		if (rs == null || rs.getCurrentRow() == null) {
            return null;
        }
		OutReachEventInfoDTO outReachEventInfoDTO=new OutReachEventInfoDTO();
		outReachEventInfoDTO.setEventId(rs.getColumnValue(0));
		outReachEventInfoDTO.setBaseLocation(rs.getColumnValue(1));
		outReachEventInfoDTO.setBeneficiaryName(rs.getColumnValue(2));
		outReachEventInfoDTO.setCouncilName(rs.getColumnValue(3));
		outReachEventInfoDTO.setEventName(rs.getColumnValue(4));
		outReachEventInfoDTO.setEventDescription(rs.getColumnValue(5));
		outReachEventInfoDTO.setEventDate(rs.getColumnValue(6));
		outReachEventInfoDTO.setEmpId(rs.getColumnValue(7));
		outReachEventInfoDTO.setEmpName(rs.getColumnValue(8));
		outReachEventInfoDTO.setVolunteerHour(rs.getColumnValue(9));
		outReachEventInfoDTO.setTravleHoures(rs.getColumnValue(10));
		outReachEventInfoDTO.setLivesImpacted(rs.getColumnValue(11));
		outReachEventInfoDTO.setBusinessUnit(rs.getColumnValue(12));
		outReachEventInfoDTO.setStatus(rs.getColumnValue(13));
		outReachEventInfoDTO.setIIEPCategory(rs.getColumnValue(14));
		return outReachEventInfoDTO;
	}

}
