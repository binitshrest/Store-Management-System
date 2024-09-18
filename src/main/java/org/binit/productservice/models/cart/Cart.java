package org.binit.productservice.models.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cart {
    private Long cartId;
    private Long userId;
    private String Date;
    private List<CartProduct> products;
}
