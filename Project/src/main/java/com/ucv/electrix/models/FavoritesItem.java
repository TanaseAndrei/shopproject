package com.ucv.electrix.models;

import javax.persistence.*;

@Entity
@Table(name = "t_favorites_item")
public class FavoritesItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
