package org.dependencytrack.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpe_code", nullable = false, unique = true)
    private String cpeCode;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private Set<CotsOss> cotsOssSet;

    // Getters et setters
}
