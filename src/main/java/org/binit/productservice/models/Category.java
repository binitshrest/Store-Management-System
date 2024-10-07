package org.binit.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseModel{
    String title;
    //by default fetch type is lazy it will execute only one query in lazy
    @OneToMany(mappedBy="category", cascade = {CascadeType.REMOVE}, fetch=FetchType.EAGER)
    @JsonIgnore
    List<Product> products;
}
