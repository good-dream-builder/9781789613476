package com.songko.api.core.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int productId = 0;
    private String name;
    private int weight = 0;
    private String serviceAddress;
}
