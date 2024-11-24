package com.teachCode.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "user_id")
    private String userId;


    @Column(name = "product_total_price")
    private int productTotalPrice;

    @Column(name = "product_total_quantity")
    private int productTotalQuantity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    @JsonIgnore
    private List<CartItems> cartItemsList;




}
