package org.binit.productservice.controllers;

import org.binit.productservice.models.Product;
import org.binit.productservice.services.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/")
    public void createProduct(){

    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> responseData = productService.getAllProducts();

        ResponseEntity<List<Product>> responseEntity =
                new ResponseEntity<>(responseData, HttpStatusCode.valueOf(202));
        return responseEntity;
    }

    @GetMapping("/products/{id}")
    public Product getSingleProductById(@PathVariable("id") Long id){
        return productService.getSingleProductById(id);
    }

//    @DeleteMapping("")
//    public void deleteProduct(){
//
//    }
}
