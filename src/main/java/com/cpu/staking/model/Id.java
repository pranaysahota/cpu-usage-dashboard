package com.cpu.staking.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Id implements Serializable {
	public Id() {
	}

	private static final long serialVersionUID = 218204585997935768L;
	@NotNull
	@Column(name = "inserted_at")
	private Timestamp insertedAt;
	@NotNull
	@Column(name = "account_name")
	private String accountName;

	public Timestamp getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(Timestamp insertedAt) {
		this.insertedAt = insertedAt;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
