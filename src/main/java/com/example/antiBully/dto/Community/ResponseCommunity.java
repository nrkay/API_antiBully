package com.example.antiBully.dto.Community;

import lombok.*;

import java.util.UUID;

@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCommunity {
    private UUID id;
    private String name;
    private String slogan;
    private String address;
    private String phone;
    private String wa;
    private String instagram;
    private String twitter;
    private String deskripsi;
    private String province;
}
