package com.example.project2.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Data
public class MerchantStock {

    @NotEmpty(message = "ID must not be empty")
    @Length(min = 3, max = 3, message = "ID have to be 3 character long")
    private String ID;
    @NotEmpty(message = "productid must not be empty")
    @Length(min = 3, max = 3, message = "productid have to be 3 character long")
    private String productid;
    @NotEmpty(message = "merchantid must not be empty")
    @Length(min = 3, max = 3, message = "merchantid have to be 3 character long")
    private String merchantid;
    @NotEmpty(message = "stock must not be empty")
    @Length(min = 10, message = "stock have to be 10 at start")
    private String stock;



}
