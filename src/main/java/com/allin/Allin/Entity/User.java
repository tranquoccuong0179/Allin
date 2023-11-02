package com.allin.Allin.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    // CascadeType.ALL để thực hiện các thao tác CRUD liên quan đến ShippingAddress khi thực hiện CRUD trên User
    // Nếu muốn tạo ShippingAddress mà không yêu cầu User, bạn có thể sử dụng CascadeType.MERGE thay vì CascadeType.ALL
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    List<ShippingAddress> shippingAddresses;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Cart cartDetail;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    List<Feedback> feedbacks;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    List<Order> orders;
}
