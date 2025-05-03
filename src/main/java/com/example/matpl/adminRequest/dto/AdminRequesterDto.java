package com.example.matpl.adminRequest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminRequesterDto {
    private String restaurantName;
    private String ownerName;
    private String ownerPhone;
    private String restaurantAddress;
    private String requestMessage;
}
