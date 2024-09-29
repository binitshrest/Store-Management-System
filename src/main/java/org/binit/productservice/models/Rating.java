package org.binit.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rating extends BaseModel{
    private double rate;
    private Integer count;
    @OneToOne(mappedBy = "rating", cascade = {CascadeType.REMOVE})
    private Product product;
}
