package com.example.imageuploder.product;

import com.example.imageuploder.s3.S3Buckets;
import com.example.imageuploder.s3.S3Service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final S3Service s3Service;
    private String bucketName = "dont-be-ass";

    public ProductService(ProductRepository productRepository, S3Service s3Service) {
        this.productRepository = productRepository;
        this.s3Service = s3Service;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(String name, String description, String price, MultipartFile image) throws IOException {
        String productImageId = UUID.randomUUID().toString();
        var url = s3Service.putObject(
                bucketName,
                productImageId,
                image.getBytes()
        );

        Product product = new Product(name, description, price, url);

        return productRepository.save(product);
    }

    public byte[] getProductImage(Long productId) {
        var product = productRepository.findById(productId).orElseThrow();
        var productImageId = product.getImageUrl();
        return s3Service.getObject(
                bucketName,
                "products-images/%s/%s".formatted(product.getName(), productImageId)
        );
    }
}
