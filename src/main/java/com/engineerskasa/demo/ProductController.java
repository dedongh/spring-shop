package com.engineerskasa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> list() {
        return service.listAll();
    }

   /* @GetMapping("/products/{product_id}")
    public Product get(@PathVariable Integer product_id) {
        return service.get(product_id);
    }*/

    @GetMapping("/products/{product_id}")
    public ResponseEntity<Product> get(@PathVariable Integer product_id) {
        try {
            Product product = service.get(product_id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public void add(@RequestBody Product product) {
        service.save(product);
    }

    @PutMapping("/products/{product_id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer product_id) {
        try {
            Product isExists = service.get(product_id);
            service.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/products/{product_id}")
    public void delete(@PathVariable Integer product_id) {
        service.delete(product_id);
    }

}
