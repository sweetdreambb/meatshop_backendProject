package com.fsse2506.project.data.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor @AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String firebaseUid;
}
