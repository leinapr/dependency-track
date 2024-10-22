package org.dependencytrack.model;

import javax.persistence.*;

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

    // Constructors
    public Product() {}

    public Product(String name, String cpeCode) {
        this.name = name;
        this.cpeCode = cpeCode;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpeCode() {
        return cpeCode;
    }

    public void setCpeCode(String cpeCode) {
        this.cpeCode = cpeCode;
    }
}
