package com.example.demo.domain.product;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

@Entity(name = "product")
@Table(name = "product")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Indicar que o ID é gerado automaticamente
    private Long id;

    private String name;
    private Integer price_in_cents;
    private Boolean active;

    public Product(RequestProductDTO requestProductDTO){
        this.name = requestProductDTO.name();
        this.price_in_cents = requestProductDTO.price_in_cents();
        this.active = true;
    }

    public Product(String name, Integer price){

    }
}
