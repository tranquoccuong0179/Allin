package com.allin.Allin.Repository;

import com.allin.Allin.Entity.Category;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
