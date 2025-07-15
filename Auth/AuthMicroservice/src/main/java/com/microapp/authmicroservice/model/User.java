package com.microapp.authmicroservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@SQLDelete(sql = "UPDATE users SET is_deleted = true,"
        + " password = 'REMOVED' WHERE id = ?")
@SQLRestriction(value = "is_deleted = false")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String nickname;

    private String password;

    @Column(nullable = false)
    private boolean isDeleted = false;
}
