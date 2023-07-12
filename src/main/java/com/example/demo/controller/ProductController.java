package com.example.demo.controller;


import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.RequestProductDTO;
import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product") // Especifica qual a url que o controller irá manipular
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity getAllProducts(){ // ResponseEntity - retornar para o cliente uma resposta
        var allProdutcs = productRepository.findAllByActiveTrue();
        return ResponseEntity.ok(allProdutcs);
    }


    @PostMapping("/add") // Inserrir elementos
    public ResponseEntity registerProducts(@RequestBody @Valid RequestProductDTO data){
        Product newProduct = new Product(data);

        productRepository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    @Transactional
    public ResponseEntity updateProduct(@PathVariable Long id,@RequestBody @Valid RequestProductDTO data){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
