package com.ucv.electrix.models;

import javax.persistence.*;

@Entity
@Table(name = "t_cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
