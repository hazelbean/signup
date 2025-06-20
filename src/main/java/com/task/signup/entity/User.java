package com.task.signup.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @Column(length = 32)
    private String id;  // 이메일 (아이디)

    @Column(nullable = false)
    private String password;
}
