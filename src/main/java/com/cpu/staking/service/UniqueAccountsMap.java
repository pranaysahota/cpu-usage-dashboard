package com.cpu.staking.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cpu.staking.model.Account;

public class UniqueAccountsMap {
	Map<String, Account> map = new HashMap<>();

	public Map<String, Account> findUniqueAccountsWithLatestTimeStamp(List<Account> allAccounts) {

		for (Account account : allAccounts) {
			if (map.containsKey(account.getId().getAccountName())) {
				Account o = map.get(account.getId().getAccountName());
				if (o.getUpdatedAt().compareTo(account.getUpdatedAt()) < 1) {
					map.put(account.getId().getAccountName(), account);
				}
			} else {
				map.put(account.getId().getAccountName(), account);
			}
		}
		return map;
	}
}
