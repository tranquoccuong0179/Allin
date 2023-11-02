package com.allin.Allin.Service.Implement;

import com.allin.Allin.Entity.Category;
import com.allin.Allin.Repository.CategoryRepository;
import com.allin.Allin.Service.CategoryService;
import com.allin.Allin.dto.Request.CreateCategoryRequest;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<ResponseObj> getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        if(categoryList.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("Null")
                    .status("400")
                    .data(null)
                    .build());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(categoryList)
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> createCategory(CreateCategoryRequest createCategoryRequest) {
        if(createCategoryRequest == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("Null")
                    .status("400")
                    .data(null)
                    .build());

        Category category = new Category();
        category.setCategoryName(createCategoryRequest.getCategoryName());
        categoryRepository.save(category);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(createCategoryRequest)
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> deleteCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("Null")
                    .status("400")
                    .data(null)
                    .build());
        categoryRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(category.get())
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> updateCategory(Long id, CreateCategoryRequest createCategoryRequest) {
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("Null")
                    .status("400")
                    .data(null)
                    .build());
        category.get().setCategoryName(createCategoryRequest.getCategoryName());
        categoryRepository.save(category.get());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(category.get())
                .build());
    }
}
