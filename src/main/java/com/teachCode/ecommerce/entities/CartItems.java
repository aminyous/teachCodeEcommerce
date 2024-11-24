package com.teachCode.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cart_items")
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_img")
    private String productImg;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private int productPrice;

    @Column(name = "product_quantity")
    private int productQuantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    public CartItems(Long id, String productName, String productId, String productImg, int productQuantity, int productPrice) {
        this.id = id;
        this.productName = productName;
        this.productId = productId;
        this.productImg = productImg;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

}
