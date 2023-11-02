package com.allin.Allin.Service.Implement;

import com.allin.Allin.Entity.Product;
import com.allin.Allin.Repository.ProductRepository;
import com.allin.Allin.Service.ProductService;
import com.allin.Allin.dto.Request.CreateProductRequest;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public ResponseEntity<ResponseObj> createProduct(CreateProductRequest createProductRequest) {
        if(createProductRequest == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("null object")
                    .status("401")
                    .data(null)
                    .build());
        }
        Product product = new Product();
        product.setProductPrice(createProductRequest.getProductPrice());
        product.setProductQuantity(createProductRequest.getProductQuantity());
        product.setProductImage(createProductRequest.getProductImage());
        product.setProductName(createProductRequest.getProductName());

        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(createProductRequest)
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> getAllProduct() {
        List<Product> productList = productRepository.findByProductQuantityGreaterThan(0);
        if (productList.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("null object")
                    .status("400")
                    .data(null)
                    .build());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(productList)
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("null object")
                    .status("400")
                    .data(null)
                    .build());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(product.get())
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("null object")
                    .status("400")
                    .data(null)
                    .build());
        product.get().setProductQuantity(0);
        productRepository.save(product.get());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("Ok")
                .status("200")
                .data(product.get())
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> updateProduct(Long id, CreateProductRequest createProductRequest) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("null object")
                    .status("400")
                    .data(null)
                    .build());
        product.get().setProductPrice(createProductRequest.getProductPrice());
        product.get().setProductQuantity(createProductRequest.getProductQuantity());
        product.get().setProductImage(createProductRequest.getProductImage());
        product.get().setProductName(createProductRequest.getProductName());
        productRepository.save(product.get());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("Ok")
                .status("200")
                .data(product.get())
                .build());
    }
}
