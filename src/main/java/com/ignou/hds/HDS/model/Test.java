package com.ignou.hds.HDS.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Auto-incremented primary key

    @Column(name = "test_name", length = 100, nullable = false)
    private String testName; // Test name (Required)

    @Column(name = "test_description", columnDefinition = "TEXT")
    private String testDescription; // Test description (Optional)

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price; // Test price (Required)
}