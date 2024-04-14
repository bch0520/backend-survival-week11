package com.example.demo.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {
    @Test
    void creation() {
        Product product = Product.create("제품명", "IMAGE_URL", new Money(123_456L));

        assertThat(product.id()).isNotNull();
        assertThat(product.name()).isEqualTo("제품명");
        assertThat(product.imageUrl()).isEqualTo("IMAGE_URL");
        assertThat(product.price()).isEqualTo(new Money(123_456L));
    }
}
