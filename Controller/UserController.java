package com.example.project2.Controller;

import com.example.project2.modle.Api;
import com.example.project2.modle.Product;
import com.example.project2.modle.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/ksa")
public class UserController {
    ArrayList<User> userslist = new ArrayList<>();

    @GetMapping
    public ResponseEntity getproduct() {
        return ResponseEntity.status(200).body(userslist);
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(message, 400));
        }
        userslist.add(user);
        return ResponseEntity.status(201).body(new Api("New product added !", 201));
    }

    @PutMapping("{index}")
    public ResponseEntity updateProduct(@RequestBody @Valid User user, @PathVariable int
            index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(message, 400));

        }
        if (index >= userslist.size()) {
            return ResponseEntity.status(400).body(new Api("Invalid index", 400));
        }
        userslist.set(index, user);
        return ResponseEntity.status(201).body(new Api("product updated !", 201));

    }

    @DeleteMapping("{index}")
    public ResponseEntity delProduct(@PathVariable int index) {
        if (index >= userslist.size()) {
            return ResponseEntity.status(400).body(new Api("Invalid index", 400));

        }
        userslist.remove(index);
        return ResponseEntity.status(200).body(new Api("product deleted !", 200));
    }


}
