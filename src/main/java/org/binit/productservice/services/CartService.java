package org.binit.productservice.services;

import org.binit.productservice.models.cart.Cart;

public interface CartService {
    public Cart getSingleCart(Long cartId);
}
