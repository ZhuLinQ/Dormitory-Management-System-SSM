package com.zlq.service;

import com.zlq.dto.AccountDto;
import com.zlq.form.AccountForm;

public interface AccountService {
    public AccountDto login(AccountForm accountForm);
}
