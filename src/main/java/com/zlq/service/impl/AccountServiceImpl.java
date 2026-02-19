package com.zlq.service.impl;

import com.zlq.dto.AccountDto;
import com.zlq.form.AccountForm;
import com.zlq.mapper.DormitoryAdminMapper;
import com.zlq.mapper.SystemAdminMapper;
import com.zlq.pojo.DormitoryAdmin;
import com.zlq.pojo.SystemAdmin;
import com.zlq.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private SystemAdminMapper systemAdminMapper;

    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;
    @Override
    public AccountDto login(AccountForm accountForm) {
        AccountDto dto = new AccountDto<>();
        switch (accountForm.getType()){
            case "systemAdmin":
                SystemAdmin systemAdmin = this.systemAdminMapper.findByUsername(accountForm.getUsername());
                //判断用户名是否正确
                if(systemAdmin == null){
                    dto.setCode(-1);
                } else {
                    //判断密码是否正确
                    if(!systemAdmin.getPassword().equals(accountForm.getPassword())){
                        dto.setCode(-2);
                    } else {
                        dto.setCode(0);
                        dto.setAdmin(systemAdmin);
                    }
                }
                break;
            case "dormitoryAdmin":
                DormitoryAdmin dormitoryAdmin = this.dormitoryAdminMapper.findByUsername(accountForm.getUsername());
                if(dormitoryAdmin == null){
                    dto.setCode(-1);
                } else {
                    if(!dormitoryAdmin.getPassword().equals(accountForm.getPassword())){
                        dto.setCode(-2);
                    } else {
                        dto.setCode(0);
                        dto.setAdmin(dormitoryAdmin);
                    }
                }
                    break;
        }
        return dto;
    }
}
