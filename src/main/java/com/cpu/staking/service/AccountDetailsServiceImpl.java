package com.cpu.staking.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
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
	@Value("${user.blockproducer.url}")
	private String blockProducerUrl;

	public List<AccountDetail> getAccountDetails() throws URISyntaxException {
		List<Account> accountList = accDetsDao.findAllByStatus(Status.STAKING_SUCCESSFUL);
		Map<String, Account> accountsMap = null;
		if (accountList.isEmpty()) {
			return Collections.emptyList();
		}
		UniqueAccountsMap mgr = new UniqueAccountsMap();
		accountsMap = mgr.findUniqueAccountsWithLatestTimeStamp(accountList);
		List<AccountDetail> accountDetails = new ArrayList<>();
		for (Map.Entry<String, Account> account : accountsMap.entrySet()) {
			accountName = new AccountName(account.getKey());
			accountDetails.add(getAccountInfoFromBlockProducer(accountName, account.getValue()));
		}
		return accountDetails;
	}

	private AccountDetail getAccountInfoFromBlockProducer(AccountName accountName, Account account)
			throws URISyntaxException {
		AccountDetail accountDetail = null;
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI(blockProducerUrl);
		try {
			accountDetail = restTemplate.postForObject(uri, accountName, AccountDetail.class);
		} catch (RestClientException e) {
			accountDetail = new AccountDetail();
			return accountDetail;
		}
		accountDetail.setTime(account.getUpdatedAt());
		return accountDetail;
	}

}
