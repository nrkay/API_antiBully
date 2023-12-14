package com.example.antiBully.dto.Province;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestProvince {
    @NotBlank(message = "Name is mandatory")
    private String name;
}
