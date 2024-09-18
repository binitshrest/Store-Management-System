package org.binit.productservice.services;

import org.binit.productservice.dtos.FakeStoreCartDto;
import org.binit.productservice.dtos.FakeStoreProductDto;
import org.binit.productservice.models.Cart;
import org.binit.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCartService implements CartService {

    RestTemplate restTemplate;
    public FakeStoreCartService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Cart getSingleCart(Long cartId){
        FakeStoreCartDto fakeStoreCartDto = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/" + cartId, FakeStoreCartDto.class
        );

        Cart cart = new Cart();
        cart.setCartId(fakeStoreCartDto.getId());
        cart.setUserId(fakeStoreCartDto.getUserId());
        cart.setDate(fakeStoreCartDto.getDate());

        // Map products from DTO to domain model
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto productDto : fakeStoreCartDto.getProducts()) {
            Product product = new Product();
            product.setId(productDto.getId());
            product.setTitle(productDto.getTitle());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setImageUrl(productDto.getImg());
//            product.setCategory(productDto.getCategory());
            products.add(product);
        }

        // Set the products to the Cart
        cart.setProducts(products);

        // Return the populated Cart object
        return cart;
    }
}
