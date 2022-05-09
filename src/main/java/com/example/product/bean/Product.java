package com.example.product.bean;



import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Timestamp;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="product")
public class Product {
    @Id
    @Column
    private int product_id;
    @Column
    private double product_price;
    @Column
    private String product_name;
    @Column
    private String product_description;
    @Column
    private Timestamp last_updated_price ;


    }

