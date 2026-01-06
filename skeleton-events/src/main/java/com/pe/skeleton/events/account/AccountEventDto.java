package com.pe.skeleton.events.account;

import com.pe.skeleton.api.dto.account.AccountDto;
import com.pe.skeleton.events.EventDto;

/**
 * Dto which represents Account Event.
 */
public class AccountEventDto extends EventDto {

    private AccountDto account;

    public AccountDto getAccount() {
        return account;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }
}
