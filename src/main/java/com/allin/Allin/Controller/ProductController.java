package com.allin.Allin.Controller;

import com.allin.Allin.Service.ProductService;
import com.allin.Allin.dto.Request.CreateProductRequest;
import com.allin.Allin.dto.Response.ResponseObj;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<ResponseObj> createProduct(@RequestBody CreateProductRequest createProductRequest){
        return productService.createProduct(createProductRequest);
    }

    @GetMapping("/getProducts")
    public ResponseEntity<ResponseObj> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<ResponseObj> getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PatchMapping("/deleteProduct/{id}")
    public ResponseEntity<ResponseObj> deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);

    }

    //Update cần có id và 1 object
    @PatchMapping("updateProduct/{id}")
    public ResponseEntity<ResponseObj> updateProduct(@PathVariable Long id, @RequestBody CreateProductRequest createProductRequest){
        return productService.updateProduct(id, createProductRequest);
    }
}
