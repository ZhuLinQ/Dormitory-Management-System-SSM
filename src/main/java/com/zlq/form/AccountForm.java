package com.zlq.form;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AccountForm {
    private String username;
    private String password;
    private String type;
}
