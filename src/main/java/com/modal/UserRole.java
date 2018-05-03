package com.modal;

import javax.persistence.*;

@Entity
public class UserRole {

    Long id;
    User user;
    Long role;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "user_role_id")
    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }
}
