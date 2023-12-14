package com.example.antiBully.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Builder
@Validated
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "province")
@SQLDelete(sql = "UPDATE province SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Province extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @OneToMany(mappedBy="province")
    private List<Communities> communities;
}
