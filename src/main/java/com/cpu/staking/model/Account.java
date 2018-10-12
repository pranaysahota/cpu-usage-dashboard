package com.cpu.staking.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "stake_orders")
public class Account {

	@EmbeddedId
	private Id id;

	@Column(name = "cpu_used")
	private int cpuUsed;

	@Column(name = "cpu_max")
	private int cpuMax;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", columnDefinition = "enum")
	private Status status;

	@Column(name = "txhash")
	private String txHash;
	
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public int getCpuUsed() {
		return cpuUsed;
	}

	public void setCpuUsed(int cpuUsed) {
		this.cpuUsed = cpuUsed;
	}

	public int getCpuMax() {
		return cpuMax;
	}

	public void setCpuMax(int cpuMax) {
		this.cpuMax = cpuMax;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTxHash() {
		return txHash;
	}

	public void setTxHash(String txHash) {
		this.txHash = txHash;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}
