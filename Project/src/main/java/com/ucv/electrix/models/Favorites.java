package com.ucv.electrix.models;

import javax.persistence.*;

@Entity
@Table(name = "t_favorites")
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
