package com.example.project2.Controller;

import com.example.project2.modle.Api;
import com.example.project2.modle.Category;
import com.example.project2.modle.Merchant;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/lan")
public class CategoryController {
    ArrayList<Category> categorlist = new ArrayList<>();

    @GetMapping
    public ResponseEntity getproduct() {
        return ResponseEntity.status(200).body(categorlist);
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody @Valid Category category, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(message, 400));
        }
        categorlist.add(category);
        return ResponseEntity.status(201).body(new Api("New product added !", 201));
    }

    @PutMapping("{index}")
    public ResponseEntity updateProduct(@RequestBody @Valid Category category , @PathVariable int
            index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(message, 400));

        }
        if (index >= categorlist.size()) {
            return ResponseEntity.status(400).body(new Api("Invalid index", 400));
        }
        categorlist.set(index, category);
        return ResponseEntity.status(201).body(new Api("product updated !", 201));

    }

    @DeleteMapping("{index}")
    public ResponseEntity delProduct(@PathVariable int index) {
        if (index >= categorlist.size()) {
            return ResponseEntity.status(400).body(new Api("Invalid index", 400));

        }
        categorlist.remove(index);
        return ResponseEntity.status(200).body(new Api("product deleted !", 200));

    }}
