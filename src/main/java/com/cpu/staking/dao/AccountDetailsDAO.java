package com.cpu.staking.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cpu.staking.model.Account;
import com.cpu.staking.model.Status;

@Repository
public interface AccountDetailsDAO extends CrudRepository<Account, Status> {

	List<Account> findAllByStatus(Status status);

}
