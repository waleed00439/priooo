package com.example.project2.Controller;

import com.example.project2.modle.Api;
import com.example.project2.modle.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/wee")
public class ProductController {

    private ArrayList<Product> Productlist = new ArrayList<>();


    @GetMapping
    public ResponseEntity getproduct() {
        return ResponseEntity.status(200).body(Productlist);
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(message, 400));
        }
        Productlist.add(product);
        return ResponseEntity.status(201).body(new Api("New product added !", 201));
    }

    @PutMapping("{index}")
    public ResponseEntity updateProduct(@RequestBody @Valid Product product, @PathVariable int
            index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(message, 400));

        }
        if (index >= Productlist.size()) {
            return ResponseEntity.status(400).body(new Api("Invalid index", 400));
        }
        Productlist.set(index, product);
        return ResponseEntity.status(201).body(new Api("product updated !", 201));

    }

    @DeleteMapping("{index}")
    public ResponseEntity delProduct(@PathVariable int index) {
        if (index >= Productlist.size()) {
            return ResponseEntity.status(400).body(new Api("Invalid index", 400));

        }
        Productlist.remove(index);
        return ResponseEntity.status(200).body(new Api("product deleted !", 200));
    }

}

