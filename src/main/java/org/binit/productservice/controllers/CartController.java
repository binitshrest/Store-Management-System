package org.binit.productservice.controllers;

import org.binit.productservice.models.cart.Cart;
import org.binit.productservice.services.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/{cartId}")
    public Cart getSingleCart(@PathVariable("cartId") Long cartId){
        return cartService.getSingleCart(cartId);
    }

    @GetMapping("/")
    public void getAllCarts(){

    }

    @PostMapping("/")
    public void addNewCart(){

    }

    @PutMapping("")
    public void updateNewCart(){

    }
    @DeleteMapping("")
    public void deleteCart(){

    }
}
