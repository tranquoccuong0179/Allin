package com.allin.Allin.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long userId;
    @Column(name = "user_name")
    String userName;
    @Column(name = "user_password")
    String password;
    @Column(name = "user_email")
    String email;
    @Column(name = "user_phone")
    String phone;
    @Column(name = "user_role")
    String role;
    @Column(name = "user_status")
    Boolean status;

}
