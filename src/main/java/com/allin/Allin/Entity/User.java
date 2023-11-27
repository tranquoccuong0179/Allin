package com.allin.Allin.Entity;

import com.allin.Allin.Entity.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long userId;

    @Column(name = "user_firstname")
    String firstname;

    @Column(name = "user_lastname")
    String lastname;

    @Column(name = "user_password")
    String password ;

    @Column(name = "user_email")
    String email;

    @Column(name = "user_phone")
    String phone;

    @Enumerated(EnumType.STRING)
    Role role;


    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    @JsonIgnore
    private List<Token> tokens;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
