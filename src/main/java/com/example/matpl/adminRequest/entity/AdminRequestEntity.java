package com.example.matpl.adminRequest.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "adminRequest")
public class AdminRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requesterEmail;

    private String restaurantName;

    private String address;

    private String phone;

    @Column
    private String description;

    private String status;

    @Builder
    public AdminRequestEntity(String requesterEmail, String restaurantName, String address, String phone, String description, String status) {
        this.requesterEmail = requesterEmail;
        this.restaurantName = restaurantName;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.status = status;
    }
}
