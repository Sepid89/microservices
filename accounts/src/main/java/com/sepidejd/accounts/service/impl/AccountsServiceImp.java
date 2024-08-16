package com.sepidejd.accounts.service.impl;

import com.sepidejd.accounts.constants.AccountsConstants;
import com.sepidejd.accounts.dto.AccountsDto;
import com.sepidejd.accounts.dto.CustomerDto;
import com.sepidejd.accounts.entity.Accounts;
import com.sepidejd.accounts.entity.Customer;
import com.sepidejd.accounts.exception.CustomerAlreadyExistsException;
import com.sepidejd.accounts.exception.ResourceNotFoundExcetion;
import com.sepidejd.accounts.mapper.AccountsMapper;
import com.sepidejd.accounts.mapper.CustomerMapper;
import com.sepidejd.accounts.repository.AccountsRepository;
import com.sepidejd.accounts.repository.CustomerRepository;
import com.sepidejd.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImp implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     *
     * @param customerDto - CustomerDto Obj
     */
    @Override
    public void createAccount(CustomerDto customerDto){
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber "
                    +customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        System.out.println(customer);
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(()->
                        new ResourceNotFoundExcetion("Customer","mobileNumber", mobileNumber));

      Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()-> new ResourceNotFoundExcetion("Account", "customerId", customer.getCustomerId().toString())
        );
      CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
      customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts,new AccountsDto()));
      return customerDto;
    }
}
