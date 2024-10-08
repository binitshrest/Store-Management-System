package org.binit.productservice.dtos.cartDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FakeStoreCartDto {
    private Long id;
    private Long userId;
    private String Date;
    private List<FakeStoreCartProductDto> products;
}
