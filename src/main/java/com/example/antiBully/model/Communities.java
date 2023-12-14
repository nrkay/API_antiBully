package com.example.antiBully.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Builder
@Validated
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "communities")
@SQLDelete(sql = "UPDATE communities SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Communities extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String image;
    private String name;
    private String slogan;
    private String address;
    private String phone;
    private String wa;
    private String instagram;
    private String twitter;
    private String deskripsi;
    @ManyToOne
    @JoinColumn(name="province_id", nullable=false)
    private Province province;
}
