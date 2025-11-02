package com.example.lab8_20202218.Controller;
import com.example.lab8_20202218.Entitys.Product;
import com.example.lab8_20202218.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // end point 1 : listar productos
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // end point 2 : hallar producto por id
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("error", "no encontrado con id: " + id);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    //end point 3: crear producto
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        product.setProductId(null);

        try {
            Product newProduct = productRepository.save(product);
            Map<String, Object> response = new HashMap<>();
            response.put("status", "Prodcuto creado");
            response.put("productId", newProduct.getProductId());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "error " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    // end point 4: actualizar productos
    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {

        if (product.getProductId() == null) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Se requiere id");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        if (!productRepository.existsById(product.getProductId())) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "El producto no esta en la BD");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        try {
            Product updatedProduct = productRepository.save(product);
            return ResponseEntity.ok(updatedProduct);

        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    // end point 5: borrar prodcuto
    @DeleteMapping("/{id}")

    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {

        if (productRepository.existsById(id)) {
            try {
                productRepository.deleteById(id);
                Map<String, String> response = new HashMap<>();
                response.put("status", "Producto eliminaado");
                return ResponseEntity.ok(response);


            }
            catch (Exception e) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "no se puede eliminar");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            }
        }
        else {
            Map<String, String> error = new HashMap<>();
            error.put("error", "No existe en la DB");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
}
