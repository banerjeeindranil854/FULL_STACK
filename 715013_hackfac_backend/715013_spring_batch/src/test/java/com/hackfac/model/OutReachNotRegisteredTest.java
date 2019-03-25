package com.hackfac.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.hackfac.constant.TestUtil;
import com.hackfac.model.OutReachNotRegisteredDTO;

@RunWith(MockitoJUnitRunner.class)
public class OutReachNotRegisteredTest {

	@Test
	public void assertTest() {
		OutReachNotRegisteredDTO outReachNotRegistered = new OutReachNotRegisteredDTO();
		outReachNotRegistered.setBaseLocation(TestUtil.TEST_STRING);
		outReachNotRegistered.setBeneficiaryName(TestUtil.TEST_STRING);
		outReachNotRegistered.setEmpId(TestUtil.TEST_STRING);
		outReachNotRegistered.setEventDate(TestUtil.TEST_STRING);
		outReachNotRegistered.setEventId(TestUtil.TEST_STRING);
		outReachNotRegistered.setEventName(TestUtil.TEST_STRING);
		
		Assert.assertEquals(outReachNotRegistered.getBaseLocation(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachNotRegistered.getBeneficiaryName(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachNotRegistered.getEmpId(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachNotRegistered.getEventDate(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachNotRegistered.getEventId(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachNotRegistered.getEventName(), TestUtil.TEST_STRING);
		
		outReachNotRegistered.toString();
		
		OutReachNotRegisteredDTO outReachNotRegisteredDTO = new OutReachNotRegisteredDTO(TestUtil.TEST_STRING,
				TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING, TestUtil.TEST_STRING,
				TestUtil.TEST_STRING);
	}
}
