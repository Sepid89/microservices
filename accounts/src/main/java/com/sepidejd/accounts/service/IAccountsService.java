package com.sepidejd.accounts.service;

import com.sepidejd.accounts.dto.CustomerDto;
import com.sepidejd.accounts.exception.CustomerAlreadyExistsException;

public interface IAccountsService {
    /**
     *
     * @param customerDto - CustomerDto Obj
     */
    void createAccount(CustomerDto customerDto) throws CustomerAlreadyExistsException;
}
