package com.hackfac.rowmapper;

import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

import com.hackfac.model.OutReachEventPmoDTO;

public class EventPmoRowMapper implements RowMapper<OutReachEventPmoDTO>{

	
	@Override
	public OutReachEventPmoDTO mapRow(RowSet rs) throws Exception {
		if (rs == null || rs.getCurrentRow() == null) {
            return null;
        }
		OutReachEventPmoDTO outReachEventPmoDTO=new OutReachEventPmoDTO();
		outReachEventPmoDTO.setEventId(rs.getColumnValue(0));
		outReachEventPmoDTO.setEmpId(rs.getColumnValue(1));
		return outReachEventPmoDTO;
	}

}
