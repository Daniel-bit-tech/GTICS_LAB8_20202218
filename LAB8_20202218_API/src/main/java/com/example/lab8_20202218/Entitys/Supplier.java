package com.example.lab8_20202218.Entitys;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Suppliers")
@Getter
@Setter
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupplierID")
    private Integer supplierId;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "ContactName")
    private String contactName;

    @Column(name = "ContactTitle")
    private String contactTitle;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "Region")
    private String region;

    @Column(name = "PostalCode")
    private String postalCode;

    @Column(name = "Country")
    private String country;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Fax")
    private String fax;

    @Column(name = "HomePage")
    @Lob
    private String homePage;


}
