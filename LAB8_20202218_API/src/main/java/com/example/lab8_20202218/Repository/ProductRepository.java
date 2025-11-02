package com.example.lab8_20202218.Repository;
import com.example.lab8_20202218.Entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}