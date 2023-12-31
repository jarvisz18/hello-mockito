package com.ixan.example.test.domain;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 2023/9/2 15:53
 * @description account pay hold
 */
public class AccountPayHold {
	private final Integer receiveId;
	private final Integer receiveLineId;


	public AccountPayHold(Integer receiveId, Integer receiveLineId) {
		this.receiveId = receiveId;
		this.receiveLineId = receiveLineId;
	}


	public Integer getReceiveId() {
		return receiveId;
	}

	public Integer getReceiveLineId() {
		return receiveLineId;
	}
}
