package com.cpu.staking.model;

import java.sql.Timestamp;

public class AccountDetail {
	public AccountDetail(String account_name, String core_liquid_balance, int ram_quota, CpuLimit cpu_limit,
			Timestamp time) {
		super();
		this.account_name = account_name;
		this.core_liquid_balance = core_liquid_balance;
		this.ram_quota = ram_quota;
		this.cpu_limit = cpu_limit;
		this.time = time;
	}

	public AccountDetail() {
	}

	private String account_name;
	private String core_liquid_balance;
	private int ram_quota;
	private CpuLimit cpu_limit;
	private Timestamp time;

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getCore_liquid_balance() {
		return core_liquid_balance;
	}

	public void setCore_liquid_balance(String core_liquid_balance) {
		this.core_liquid_balance = core_liquid_balance;
	}

	public int getRam_quota() {
		return ram_quota;
	}

	public void setRam_quota(int ram_quota) {
		this.ram_quota = ram_quota;
	}

	public CpuLimit getCpu_limit() {
		return cpu_limit;
	}

	public void setCpu_limit(CpuLimit cpu_limit) {
		this.cpu_limit = cpu_limit;
	}
}