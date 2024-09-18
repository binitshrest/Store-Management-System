package org.binit.productservice.services;

import org.binit.productservice.models.Cart;

public interface CartService {
    public Cart getSingleCart(Long cartId);
}
