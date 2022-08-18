package com.bomsbro.common.security;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomPrincipal implements Serializable {
    private Long accountId;
    private Long groupId;
    private String userId;
}
