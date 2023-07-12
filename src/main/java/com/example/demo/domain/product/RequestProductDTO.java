package com.example.demo.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record RequestProductDTO(@NotBlank String name,
                                @NotNull Integer price_in_cents) { // é um tipo de classe que armazena dados.
}
