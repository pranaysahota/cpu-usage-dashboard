package com.cpu.staking.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.cpu.staking.model.AccountDetail;
import com.cpu.staking.service.AccountDetailsService;

/**
 * Controller class to access the ReST Resource
 * 
 * @author pranay
 *
 */
@Controller
public class CPUsageController {
	@Autowired
	private AccountDetailsService accountDetailsService;

	/*
	 * get call to for fetching the updated accounts from the main-net
	 */
	@GetMapping(value = "/dashboard")
	@ModelAttribute("accounts")
	public List<AccountDetail> getAccountDetails(Model model) throws URISyntaxException {
		List<AccountDetail> accounts = accountDetailsService.getAccountDetails();
		return accounts;
	}
}