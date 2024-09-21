package org.binit.productservice.controllers;

import org.binit.productservice.dtos.CreateProductRequestDto;
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

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto productRequestDto){
        return productService.createProduct(
                productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getPrice(),
                productRequestDto.getImageUrl(),
                productRequestDto.getCategory()
//                productRequestDto.getRating()
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
    public ResponseEntity<Product>  updateProduct(
            @PathVariable Long id,
            @RequestBody CreateProductRequestDto productRequestDto
    ) {
        // Call the service layer to update the product
        Product updatedProduct = productService.updateAProduct(
                id,
                productRequestDto.getTitle(),
                productRequestDto.getImageUrl(),
                productRequestDto.getDescription(),
                productRequestDto.getCategory(),
                productRequestDto.getPrice()
        );

        // Return the updated product with HTTP status OK (200)
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/products/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category) {
        return productService.getProductsByCategory(category);
    }
//
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();  // Return 204 No Content if successful
    }
}
