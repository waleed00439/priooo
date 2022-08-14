package com.example.project2.Controller;

import com.example.project2.modle.Api;
import com.example.project2.modle.MerchantStock;
import com.example.project2.modle.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/SSA")
public class MerchantStockController {

    ArrayList<MerchantStock> merchantStocklist = new ArrayList<>();

    @GetMapping
    public ResponseEntity getproduct() {
        return ResponseEntity.status(200).body(merchantStocklist);
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody @Valid MerchantStock merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(message, 400));
        }
        merchantStocklist.add(merchant);
        return ResponseEntity.status(201).body(new Api("New product added !", 201));
    }

    @PutMapping("{index}")
    public ResponseEntity updateProduct(@RequestBody @Valid MerchantStock merchant, @PathVariable int
            index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(message, 400));

        }
        if (index >= merchantStocklist.size()) {
            return ResponseEntity.status(400).body(new Api("Invalid index", 400));
        }
        merchantStocklist.set(index, merchant);
        return ResponseEntity.status(201).body(new Api("product updated !", 201));

    }

    @DeleteMapping("{index}")
    public ResponseEntity delProduct(@PathVariable int index) {
        if (index >= merchantStocklist.size()) {
            return ResponseEntity.status(400).body(new Api("Invalid index", 400));

        }
        merchantStocklist.remove(index);
        return ResponseEntity.status(200).body(new Api("product deleted !", 200));
    }



}
