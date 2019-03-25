package com.hackfse.fdbck.mgmt.systm.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

public class CmnUtils {
	
	private CmnUtils() {
		super();
	}

	public static LocalDateTime getLclDtTm(final String date) {
		return StringUtils.isNotEmpty(date) ? LocalDateTime.parse(date, DateTimeFormatter.ofPattern("DD-MM-YY"))
				: LocalDateTime.now();
	}

}
