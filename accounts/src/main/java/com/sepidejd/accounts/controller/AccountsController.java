package com.sepidejd.accounts.controller;

import com.sepidejd.accounts.constants.AccountsConstants;
import com.sepidejd.accounts.dto.CustomerDto;
import com.sepidejd.accounts.dto.ResponseDto;
import com.sepidejd.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    private IAccountsService iAccountsService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
        iAccountsService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber){
       CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);
       return ResponseEntity.status(HttpStatus.FOUND).body(customerDto);
    }
}
