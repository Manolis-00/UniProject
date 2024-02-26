package com.project.model.users;

import lombok.Getter;

@Getter
public enum UserAccountStatus {

    ACTIVE,
    BLOCKED,
    OPEN,
    SUSPENDED;
}
