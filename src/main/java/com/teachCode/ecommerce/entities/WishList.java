package com.teachCode.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "wishlist")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wishlist_seq")
    @SequenceGenerator(name = "wishlist_seq", sequenceName = "wishlist_seq")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;


    @OneToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WishList wishList)) return false;
        return Objects.equals(getId(), wishList.getId()) && Objects.equals(getUserId(),
                wishList.getUserId()) && Objects.equals(getProduct(), wishList.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getProduct());
    }



}
