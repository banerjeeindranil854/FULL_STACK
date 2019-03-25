package com.hackfac.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.hackfac.constant.TestUtil;
import com.hackfse.fdbck.mgmt.systm.model.OutReachEventInfoDTO;
import com.hackfse.fdbck.mgmt.systm.model.OutReachStatusDTO;

@RunWith(MockitoJUnitRunner.class)
public class OutReachStatusTest {

	@Test
	public void assertionTest() {
		OutReachStatusDTO outReachStatusDTO = new OutReachStatusDTO();

		outReachStatusDTO.setDescription(TestUtil.TEST_STRING);
		outReachStatusDTO.setEmpId(TestUtil.TEST_STRING);
		outReachStatusDTO.setEventId(TestUtil.TEST_STRING);
		outReachStatusDTO.setRating(TestUtil.TEST_STRING);

		Assert.assertEquals(outReachStatusDTO.getDescription(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachStatusDTO.getEmpId(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachStatusDTO.getEventId(), TestUtil.TEST_STRING);
		Assert.assertEquals(outReachStatusDTO.getRating(), TestUtil.TEST_STRING);

		OutReachStatusDTO OutReachStatusDTO1 = new OutReachStatusDTO(TestUtil.TEST_STRING, TestUtil.TEST_STRING,
				TestUtil.TEST_STRING, TestUtil.TEST_STRING);
	}
}
