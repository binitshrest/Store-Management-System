package org.binit.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binit.productservice.models.Product;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FakeStoreCartDto {
    private Long id;
    private Long userId;
    private String Date;
    private List<FakeStoreProductDto> products;
}
