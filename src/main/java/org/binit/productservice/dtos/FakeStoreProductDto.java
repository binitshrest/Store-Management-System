package org.binit.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binit.productservice.models.Product;
import org.binit.productservice.models.Rating;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String Category;
    private String description;
    private String image;
//    private FakeStoreRatingDto rating;

    public Product toProduct(){
        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setPrice(getPrice());
        product.setDescription(getDescription());
        product.setImageUrl(getImage());
        product.setCategory(getCategory());

//        Rating rating = new Rating();
//        rating.setRate(getRating().getRate());
//        rating.setCount(getRating().getCount());
//        product.setRating(rating);
        return product;
    }
}
