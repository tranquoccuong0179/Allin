package com.allin.Allin.dto.Request;

import com.fasterxml.jackson.databind.node.DoubleNode;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductRequest {


    Double productPrice;

    int productQuantity;

    String productImage;

    String productName;

}
