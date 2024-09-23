package org.binit.productservice.services;

import org.binit.productservice.dtos.cartDto.FakeStoreCartDto;
import org.binit.productservice.dtos.cartDto.FakeStoreCartProductDto;
import org.binit.productservice.models.cart.Cart;
import org.binit.productservice.models.cart.CartProduct;
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

        // Map products from DTO to Cart model
        List<CartProduct> products = new ArrayList<>();
        for (FakeStoreCartProductDto productDto : fakeStoreCartDto.getProducts()) {
            CartProduct cartProduct = new CartProduct();
            cartProduct.setProductId(productDto.getProductId());
            cartProduct.setQuantity(productDto.getQuantity());
            products.add(cartProduct);
        }

        cart.setProducts(products);

        // Return the populated Cart object
        return cart;
    }
}
