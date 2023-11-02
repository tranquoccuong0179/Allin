package com.allin.Allin.Controller;


import com.allin.Allin.Service.CategoryService;
import com.allin.Allin.dto.Request.CreateCategoryRequest;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAllCategory")
    public ResponseEntity<ResponseObj> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @PostMapping("/createCategory")
    public ResponseEntity<ResponseObj> createCategory(@RequestBody CreateCategoryRequest createCategoryRequest){
        return categoryService.createCategory(createCategoryRequest);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<ResponseObj> deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }

    @PatchMapping("/updateCategory/{id}")
    public ResponseEntity<ResponseObj> updateCategory(@PathVariable Long id, @RequestBody CreateCategoryRequest createCategoryRequest){
        return categoryService.updateCategory(id, createCategoryRequest);
    }
}