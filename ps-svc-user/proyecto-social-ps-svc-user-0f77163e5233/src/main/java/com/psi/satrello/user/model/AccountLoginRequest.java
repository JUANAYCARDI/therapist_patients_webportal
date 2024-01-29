package com.psi.satrello.user.model;

import lombok.Data;

// Model used to receive the data of a new registered user, including their password
@Data
public class AccountLoginRequest {
    private String name;
    private String username;

    private String personalId;
    private Long roleId;
    private String phone;
    private String email;
    private String password;
    private String avatarUrl;
    private Integer stateId;
}

