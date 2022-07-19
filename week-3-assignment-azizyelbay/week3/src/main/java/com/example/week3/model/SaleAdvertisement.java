package com.example.week3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="SaleAdvertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String photo;
    private String detailMessage;
    private String priceGraphPath;
}
