package com.example.lab8_20202218.Entitys;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;


@Entity
@Table(name = "Products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Integer productId;

    @Column(name = "ProductName")
    private String productName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SupplierID")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CategoryID")
    private Category category;

    @Column(name = "QuantityPerUnit")
    private String quantityPerUnit;

    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;

    @Column(name = "UnitsInStock")
    private Short unitsInStock;

    @Column(name = "UnitsOnOrder")
    private Short unitsOnOrder;

    @Column(name = "ReorderLevel")
    private Short reorderLevel;

    @Column(name = "Discontinued")
    private boolean discontinued;


}
