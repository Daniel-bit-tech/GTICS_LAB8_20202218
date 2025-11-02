package com.example.lab8_20202218_cliente.Controller;

import com.example.lab8_20202218_cliente.DTOS.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
public class ProductClientController {

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:8080/product";


    @GetMapping(value = {"/", "/product/list"})
    public String getProductList(Model model,
                                 @RequestParam(name = "id", required = false) String id) {

        try {
            ProductDto[] products = restTemplate.getForObject(API_URL, ProductDto[].class);
            model.addAttribute("products", products);

        } catch (Exception e) {
            model.addAttribute("errorList", "error: " + e.getMessage());
        }

        if (id != null && !id.trim().isEmpty()) {

            try {
                ProductDto product = restTemplate.getForObject(API_URL + "/" + id, ProductDto.class);
                model.addAttribute("productFound", product);

            } catch (HttpClientErrorException.BadRequest e) {
                model.addAttribute("errorSearch", "Producto no encontrado o id inválido");

            } catch (Exception e) {
                model.addAttribute("errorSearch", "Error" + e.getMessage());
            }
        }

        return "index";
    }
}
