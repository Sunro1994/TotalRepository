package com.SpringSecurity.practiceForRealTraining.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleType {
    USER, ROOM_MANAGER, MEMBER, ADMIN
}
