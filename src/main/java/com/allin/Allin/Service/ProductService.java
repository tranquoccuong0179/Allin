package com.allin.Allin.Service;

import com.allin.Allin.dto.Request.CreateProductRequest;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<ResponseObj> createProduct(CreateProductRequest createProductRequest);

    ResponseEntity<ResponseObj> getAllProduct();

    ResponseEntity<ResponseObj> getProductById(Long id);

    ResponseEntity<ResponseObj> deleteProduct(Long id);

    ResponseEntity<ResponseObj> updateProduct(Long id, CreateProductRequest createProductRequest);
}
