package com.hackfac.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.hackfac.constant.TestUtil;
import com.hackfse.fdbck.mgmt.systm.model.OutReachEventSummeryDTO;

@RunWith(MockitoJUnitRunner.class)
public class OutReachEventSummeryTest {
	@Test
	public void assertionTest() {
		OutReachEventSummeryDTO outReachEventSummery = new OutReachEventSummeryDTO();
		outReachEventSummery.setBaseLocation(TestUtil.TEST_STRING);
		outReachEventSummery.setBeneficiaryName(TestUtil.TEST_STRING);
		outReachEventSummery.setCategory(TestUtil.TEST_STRING);
		outReachEventSummery.setCouncilName(TestUtil.TEST_STRING);
		outReachEventSummery.setEventDate(TestUtil.TEST_STRING);
		outReachEventSummery.setEventDescription(TestUtil.TEST_STRING);
		outReachEventSummery.setEventId(TestUtil.TEST_STRING);
		outReachEventSummery.setEventName(TestUtil.TEST_STRING);
		outReachEventSummery.setMonth(TestUtil.TEST_STRING);
		outReachEventSummery.setOverallVolunteerHours(TestUtil.TEST_STRING);
		outReachEventSummery.setProject(TestUtil.TEST_STRING);
		outReachEventSummery.setTotalTravleHoures(TestUtil.TEST_STRING);
		outReachEventSummery.setTotalVolunteer(TestUtil.TEST_STRING);
		outReachEventSummery.setTotalVolunteerHour(TestUtil.TEST_STRING);
		outReachEventSummery.setVenueAddress(TestUtil.TEST_STRING);
		
		Assert.assertEquals(outReachEventSummery.getBaseLocation(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getBeneficiaryName(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getCategory(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getCouncilName(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getEventDate(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getEventDescription(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getEventId(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getEventName(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getMonth(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getOverallVolunteerHours(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getProject(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getTotalTravleHoures(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getTotalVolunteer(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getTotalVolunteerHour(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachEventSummery.getVenueAddress(), TestUtil.TEST_STRING);
		
		
		OutReachEventSummeryDTO OutReachEventSummeryDTO = new OutReachEventSummeryDTO(TestUtil.TEST_STRING,
				TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING,
				TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING,
				TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING,
				TestUtil.TEST_STRING, TestUtil.TEST_STRING);
	}
}
