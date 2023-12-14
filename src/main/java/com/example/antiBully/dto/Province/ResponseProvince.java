package com.example.antiBully.dto.Province;

import com.example.antiBully.model.Communities;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Validated
@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProvince {
    private UUID id;
    private String name;
    private List<Communities> communities;
}
