package org.binit.productservice.services;

import org.binit.productservice.dtos.FakeStoreProductDto;
import org.binit.productservice.dtos.FakeStoreRatingDto;
import org.binit.productservice.models.Product;
import org.binit.productservice.models.Rating;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakestoreproduct")
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
//        product.setId(fakeStoreProductDto.getId());
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

    @Override
    public Product createProduct( String title, String description,
                                  double price, String imageUrl,
                                  String category,
                                  FakeStoreRatingDto rating
    ){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setCategory(category);

        FakeStoreRatingDto fakeStoreRatingDto = new FakeStoreRatingDto();
        fakeStoreRatingDto.setRate(rating.getRate());   // Correctly extract rate
        fakeStoreRatingDto.setCount(rating.getCount()); // Correctly extract count

        // Set the rating in the product DTO
        fakeStoreProductDto.setRating(fakeStoreRatingDto);


        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class
        );
        return response.toProduct();
    }

    @Override
    public Product updateAProduct(Long id, String title, String image,
                                  String description, String category, double price){
        String url = "https://fakestoreapi.com/products/" + id;

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);

        HttpEntity<FakeStoreProductDto> requestEntity =
                new HttpEntity<>(fakeStoreProductDto);
        // Use exchange to perform a PUT and expect a response body

        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.PUT,
                        requestEntity,
                        FakeStoreProductDto.class
                );
        return response.getBody().toProduct();
    }

    public List<Product> getProductsByCategory(String category){
//        String url = "https://fakestoreapi.com/products/category/" + category;

        FakeStoreProductDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/category/" + category
                , FakeStoreProductDto[].class
        );

        List<Product> products = new ArrayList<>();
        if(response != null){
            for(FakeStoreProductDto fakeStoreProductDto : response){
                products.add(fakeStoreProductDto.toProduct());
            }
        }
        return products;
    }
    @Override
    public void deleteProductById(Long id) {
        String url = "https://fakestoreapi.com/products/" + id;
        restTemplate.delete(url);
    }

}
