package com.ixan.transfer.infrastructure.common.enums;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2023/9/10 20:16
 * @description grant type constants
 */
public enum GrantTypeEnum {

	RED_PAPER(GrantTypeConstants.RED_PAPER),
	SHOPPING(GrantTypeConstants.SHOPPING),
	QQ_VIP(GrantTypeConstants.QQ_VIP),
	TAKEOUT_VIP(GrantTypeConstants.TAKEOUT_VIP),

	;
	private final String value;

	GrantTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
