package com.cpu.staking.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cpu.staking.dao.AccountDetailsDAO;
import com.cpu.staking.model.Account;
import com.cpu.staking.model.AccountDetail;
import com.cpu.staking.model.AccountName;
import com.cpu.staking.model.Status;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {
	@Autowired
	private AccountDetailsDAO accDetsDao;
	private AccountName accountName;

	public List<AccountDetail> getAccountDetails() throws URISyntaxException {
		List<Account> accountList = accDetsDao.findAllByStatus(Status.STAKING_SUCCESSFUL);
		List<AccountDetail> accountDetails = null;
		if(accountList.isEmpty()) {
			accountDetails = Collections.emptyList();
		}
		else {
			accountDetails = new ArrayList<AccountDetail>();
			for (Account account : accountList) {
				accountName = new AccountName(account.getId().getAccountName());
				accountDetails.add(getAccountInfoFromBlockChain(accountName));
			}
		}
		return accountDetails;
	}

	private AccountDetail getAccountInfoFromBlockChain(AccountName accountName) throws URISyntaxException {
		AccountDetail accountDetail = null;
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI("https://api.eosnewyork.io/v1/chain/get_account");
		accountDetail = restTemplate.postForObject(uri, accountName, AccountDetail.class);
		accountDetail.setTimestamp(System.currentTimeMillis());
		return accountDetail;
	}

}
