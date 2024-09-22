package org.binit.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binit.productservice.models.Rating;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequestDto {
    private String title;
    private String imageUrl;
    private String description;
    private String category;
    private double price;
    private FakeStoreRatingDto rating;
}
