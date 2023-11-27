package com.allin.Allin.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tbl_product")
public class    Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    Long productId;

    @Column(name = "product_price")
    double productPrice;

    @Column(name = "product_quantity")
    int productQuantity;

    @Column(name = "product_image")
    String productImage;

    @Column(name = "product_name")
    String productName;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @JsonBackReference
    Category category;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    List<Feedback> feedbacks;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<Cart> cartDetails;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<OrderDetail> orderDetails;

}
