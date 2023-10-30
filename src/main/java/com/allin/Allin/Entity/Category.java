package com.allin.Allin.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tbl_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    Long categoryId;

    @Column(name = "category_name")
    String categoryName;

    // CascadeType.ALL để thực hiện các thao tác CRUD liên quan đến Product khi thực hiện CRUD trên Category
    // orphanRemoval = true để xóa Product liên quan khi Category bị xóa
    @OneToOne(mappedBy = "category", cascade = CascadeType.ALL)
    Product product;

}
