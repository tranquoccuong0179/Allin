package com.allin.Allin.Service;


import com.allin.Allin.dto.Request.CreateCategoryRequest;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    ResponseEntity<ResponseObj> getAllCategory();

    ResponseEntity<ResponseObj> createCategory(CreateCategoryRequest createCategoryRequest);

    ResponseEntity<ResponseObj> deleteCategory(Long id);

    ResponseEntity<ResponseObj> updateCategory(Long id, CreateCategoryRequest createCategoryRequest);
}
