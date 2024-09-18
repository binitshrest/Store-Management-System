package org.binit.productservice.controllers;

import org.binit.productservice.models.Product;
import org.binit.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/")
    public void getAllProducts(){

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
