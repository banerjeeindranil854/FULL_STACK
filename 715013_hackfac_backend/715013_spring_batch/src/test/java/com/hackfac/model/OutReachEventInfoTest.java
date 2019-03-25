package com.hackfac.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.hackfac.constant.TestUtil;
import com.hackfac.model.OutReachEventInfoDTO;

@RunWith(MockitoJUnitRunner.class)
public class OutReachEventInfoTest {

	@Test
	public void assertionTest() {
		OutReachEventInfoDTO outReachEventInfoDTO = new OutReachEventInfoDTO();

		outReachEventInfoDTO.setBaseLocation(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setBeneficiaryName(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setBusinessUnit(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setCouncilName(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setEmpId(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setEmpName(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setEventDate(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setEventDescription(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setEventId(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setEventName(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setIIEPCategory(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setVolunteerHour(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setTravleHoures(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setLivesImpacted(TestUtil.TEST_STRING);
		outReachEventInfoDTO.setStatus(TestUtil.TEST_STRING);

		Assert.assertEquals(outReachEventInfoDTO.getBaseLocation(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getBeneficiaryName(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getBusinessUnit(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getCouncilName(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getEmpId(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getEmpName(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getEventDate(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getEventDescription(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getEventId(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getEventName(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getIIEPCategory(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getVolunteerHour(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getTravleHoures(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getLivesImpacted(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventInfoDTO.getStatus(), TestUtil.TEST_STRING);
		OutReachEventInfoDTO outReachEventInfoDTO1 = new OutReachEventInfoDTO(TestUtil.TEST_STRING,
				TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING,
				TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING,
				TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING,
				TestUtil.TEST_STRING, TestUtil.TEST_STRING);
	}
}
