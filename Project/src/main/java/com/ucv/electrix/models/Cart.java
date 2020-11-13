package com.ucv.electrix.models;

import javax.persistence.*;

@Entity
@Table(name = "t_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
