package com.db.kursach.models;

import jakarta.persistence.*;

public class Image {
    private Long id;
    private String name;
    private String originalFileName;
    private Long size;
    private String contentType;
    private byte[] bytes;
    @OneToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private Employee employee;
}
