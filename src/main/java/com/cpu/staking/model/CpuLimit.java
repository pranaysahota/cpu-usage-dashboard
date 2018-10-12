package com.cpu.staking.model;

public class CpuLimit {

	protected int used;
	protected String available;
	protected String max;

	public int getUsed() {
		return used;
	}

	public String getAvailable() {
		return available;
	}

	public String getMax() {
		return max;
	}

	public void setUsed(int used) {
		this.used = used;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public CpuLimit() {
	}

	public CpuLimit(int used, String available, String max) {
		super();
		this.used = used;
		this.available = available;
		this.max = max;
	}
}
