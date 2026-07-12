package com.matb.miniolx.user;

import com.matb.miniolx.advertisement.Advertisement;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, updatable = false)
    private UUID userId = UUID.randomUUID();

    @OneToMany(mappedBy = "user")
    private List<Advertisement> advertisements;

    @Column(name = "email", length=100, nullable=false, unique=true)
    private String email;

    @Column(name = "password", length=100, nullable=false, unique=false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @CreatedDate
    private LocalDateTime creationDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
