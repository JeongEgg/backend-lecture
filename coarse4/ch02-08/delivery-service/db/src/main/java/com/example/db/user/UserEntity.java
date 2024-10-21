package com.example.db.user;


import com.example.db.BaseEntity;
import com.example.db.user.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity // 해당 클래스의 이름을 스네이크 케이스로 바꾸어 db의 테이블 이름을 찾는 역할을 한다.
@Table(name = "user") // 테이블의 이름을 갖고 db 에서 매칭시켜 사용함.
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserEntity extends BaseEntity {

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(length = 150, nullable = false)
    private String address;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime lastLoginAt;
}
