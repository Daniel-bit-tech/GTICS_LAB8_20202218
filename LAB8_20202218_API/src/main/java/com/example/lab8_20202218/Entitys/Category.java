package com.example.lab8_20202218.Entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Categories")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Integer categoryId;

    @Column(name = "CategoryName")
    private String categoryName;

    @Column(name = "Description")
    @Lob
    private String description;

    @Column(name = "Picture")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;


}
