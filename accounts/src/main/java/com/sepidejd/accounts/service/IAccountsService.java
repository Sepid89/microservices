package com.sepidejd.accounts.service;

import com.sepidejd.accounts.dto.CustomerDto;
import com.sepidejd.accounts.exception.CustomerAlreadyExistsException;

public interface IAccountsService {


    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    CustomerDto fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDto - CustomerDto Obj
     */
    void createAccount(CustomerDto customerDto) throws CustomerAlreadyExistsException;
}
