package com.hackfac.model;

import org.junit.Assert;
import org.junit.Test;

import com.hackfac.constant.TestUtil;
import com.hackfac.model.OutReachRegisteredDTO;

public class OutReachRegisteredTest {
	@Test
	public void assertTest() {
		OutReachRegisteredDTO outReachRegistered = new OutReachRegisteredDTO();
		outReachRegistered.setBaseLocation(TestUtil.TEST_STRING);
		outReachRegistered.setBeneficiaryName(TestUtil.TEST_STRING);
		outReachRegistered.setEmpId(TestUtil.TEST_STRING);
		outReachRegistered.setEventDate(TestUtil.TEST_STRING);
		outReachRegistered.setEventId(TestUtil.TEST_STRING);
		outReachRegistered.setEventName(TestUtil.TEST_STRING);
		
		Assert.assertEquals(outReachRegistered.getBaseLocation(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachRegistered.getBeneficiaryName(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachRegistered.getEmpId(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachRegistered.getEventDate(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachRegistered.getEventId(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachRegistered.getEventName(), TestUtil.TEST_STRING);
		outReachRegistered.toString();
		
		OutReachRegisteredDTO outReachRegisteredDTO = new OutReachRegisteredDTO(TestUtil.TEST_STRING,
				TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING,
				TestUtil.TEST_STRING);
	}
}
