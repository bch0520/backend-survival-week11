package com.example.demo.application.product;

import com.example.demo.models.Money;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreateProductServiceTest {
    private ProductRepository productRepository;

    private CreateProductService createProductService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);

        createProductService = new CreateProductService(productRepository);
    }

    @Test
    void createProduct() {
        String name = "제-품";
        String imageUrl = "IMAGE_URL";
        Money price = new Money(100_000L);

        Product product = createProductService.createProduct(name, imageUrl, price);

        assertThat(product.name()).isEqualTo(name);
        assertThat(product.imageUrl()).isEqualTo(imageUrl);
        assertThat(product.price()).isEqualTo(price);

        verify(productRepository).save(product);
    }
}
