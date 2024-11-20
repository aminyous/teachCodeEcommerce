package com.teachCode.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "product_status")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "status_name")
    private String statusName;

    @OneToMany(mappedBy = "productStatus")
    @JsonIgnore
    private Set<Product> products;

}
