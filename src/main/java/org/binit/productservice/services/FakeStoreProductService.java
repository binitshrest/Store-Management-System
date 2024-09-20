package org.binit.productservice.services;

import org.binit.productservice.dtos.FakeStoreProductDto;
import org.binit.productservice.models.Product;
import org.binit.productservice.models.Rating;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProductById(Long id) {
//        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class
        );

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setCategory(fakeStoreProductDto.getCategory());

        Rating rating = new Rating();
        rating.setRate(fakeStoreProductDto.getRating().getRate());
        rating.setCount(fakeStoreProductDto.getRating().getCount());
        product.setRating(rating);
        return product;
    }

    @Override
    public List<Product> getAllProducts(){
        FakeStoreProductDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        ); //This will get array of products as a response from fakeStoreapi
        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto: response){
            products.add(fakeStoreProductDto.toProduct());
        } // response is the array it will do for each response use fakeSoreProductDto class and add in product.

        return products;
    }
}
