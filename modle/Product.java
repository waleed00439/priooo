package com.example.project2.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
public class Product {
    @NotEmpty(message = "ID must not be empty")
    @Length(min = 3, message = "ID have to be 3 character long")
    private String ID;
    @NotEmpty(message = "name must not be empty")
    @Length(min = 3, message = "name have to be 3 length long")
    private String name;
    @Min(value = 1, message = "price  must be positive number ")
    @NotNull(message = "price must not be empty")
    private int price;
    @NotEmpty(message = "categoryID must not be empty")
    @Length(min = 3, message = "categoryID have to be 3 character long")
    private String categoryID;

}
