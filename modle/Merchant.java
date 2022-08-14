package com.example.project2.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Data
public class Merchant {

    @NotEmpty(message = "ID must not be empty")
    @Length(min = 3, max = 3, message = "ID have to be 3 character long")
    private String ID;
    @NotEmpty(message = "name must not be empty")
    @Length(min = 3, max = 3, message = "name have to be 3 length long")
    private String name;
}
