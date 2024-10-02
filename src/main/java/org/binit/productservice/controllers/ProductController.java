package org.binit.productservice.controllers;

import org.binit.productservice.dtos.CreateProductRequestDto;
import org.binit.productservice.dtos.ErrorDto;
import org.binit.productservice.models.Product;
import org.binit.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    ProductService productService;
    public ProductController(@Qualifier("productserviceimple") ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto productRequestDto){
        return productService.createProduct(
                productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getPrice(),
                productRequestDto.getImageUrl(),
                productRequestDto.getCategory()
        );
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

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody CreateProductRequestDto productRequestDto
    ) {
        // Map DTO to Product entity
        Product inputProduct = mapToEntity(id, productRequestDto);

        // Call the service layer to update the product
        Product updatedProduct = productService.updateAProduct(
                inputProduct
        );

        // Return the updated product with HTTP status OK (200)
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/products/by-title-and-price")
    public List<Product> getByTitleAndCategory(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "price", required = false) Double price) {

        return productService.getByTitleAndPrice(title, price);
    }
    //Get product by price

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();  // Return 204 No Content if successful
    }

    private Product mapToEntity(Long id, CreateProductRequestDto dto) {
        Product product = new Product();
        product.setId(id);
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImageUrl(dto.getImageUrl());
        return product;
    }
}
