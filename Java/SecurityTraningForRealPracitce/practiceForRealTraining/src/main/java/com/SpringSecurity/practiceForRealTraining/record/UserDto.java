package com.SpringSecurity.practiceForRealTraining.record;

import com.SpringSecurity.practiceForRealTraining.model.RoleType;
import com.SpringSecurity.practiceForRealTraining.model.User;
import com.SpringSecurity.practiceForRealTraining.model.UserStatus;

import java.time.LocalDateTime;

public record UserDto(
        Long userId,
        String loginId,
        String username,
        String password,
        UserStatus status,
        String email,
        RoleType roleType,
//        List<UserDetailsDto> userDetails, // 계정에서의 참조는 없앤다.
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    // factory method of 선언
    public static UserDto of(Long userId, String loginId, String username, String password, UserStatus status, String email, RoleType roleType, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new UserDto(userId, loginId, username, password, status, email, roleType, createdAt, updatedAt);
    }

    // security에서 사용할 팩토리 메서드
    public static UserDto of(String loginId) {
        return new UserDto(
                null, loginId, null, null, null, null, null, null, null
        );
    }

    public static UserDto fromEntity(User entity) {
        return UserDto.of(
                entity.getId(),
                entity.getLoginId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getUserStatus(),
                entity.getEmail(),
                entity.getRoleType(),

//                userDetails,
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }


}
