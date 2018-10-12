package com.cpu.staking.service;

import java.net.URISyntaxException;
import java.util.List;

import com.cpu.staking.model.AccountDetail;

public interface AccountDetailsService {
	List<AccountDetail> getAccountDetails() throws URISyntaxException;
}
