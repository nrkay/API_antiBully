package com.example.antiBully.dto.Community;

import com.example.antiBully.model.Province;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.annotation.Validated;


@Validated
@Data
@Builder
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCommunity {
    @NotBlank(message = "Name is mandatory")
    private String name;
    private String image;
    private String slogan;
    private String address;
    private String phone;

    private String wa;

    private String instagram;

    private String twitter;

    private String deskripsi;

    private Province province;
}
