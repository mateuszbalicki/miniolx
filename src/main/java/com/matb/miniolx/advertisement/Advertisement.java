package com.matb.miniolx.advertisement;

import com.matb.miniolx.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "ADVERTISEMENT")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, updatable = false)
    private UUID advertisementId = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title", length=100, nullable=false, unique=false)
    private String title;

    @Column(name = "description", length=2000, nullable=false, unique=false)
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private AdvertisementStatus status;

    @CreatedDate
    private LocalDateTime creationDate;

    @LastModifiedBy
    private long lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

}
