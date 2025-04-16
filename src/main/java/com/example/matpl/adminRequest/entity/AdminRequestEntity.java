package com.example.matpl.adminRequest.entity;

import com.example.matpl.adminRequest.emum.AdminRequestStatus;
import com.example.matpl.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "admin_request_info")
@Builder
public class AdminRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String restaurantName;

    @Column
    private String ownerName;

    @Column
    private String ownerPhone;

    @Column
    private String restaurantAddress;

    @ManyToOne
    private UserEntity requesterEmail;

    @Column
    private String requesterMessage;

    @Column
    private String adminReplyMessage;

    @Column
    @Enumerated(EnumType.STRING)
    private AdminRequestStatus status;
}
