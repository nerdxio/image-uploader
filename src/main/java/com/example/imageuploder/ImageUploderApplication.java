package com.example.imageuploder;

import com.example.imageuploder.s3.S3Buckets;
import com.example.imageuploder.s3.S3Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class ImageUploderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageUploderApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(S3Service s3Service, S3Buckets s3Buckets) {
        return args -> {
//            s3Service.putObject(s3Buckets.getName(), "test", "test".getBytes());
//            byte[] object = s3Service.getObject(s3Buckets.getName(), "test");
//
//            System.out.println("object = " + new String(object));
        };

    }
}
