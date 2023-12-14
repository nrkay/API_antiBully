package com.example.antiBully.model;

import jakarta.persistence.Lob;

public class Images {
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;
}
