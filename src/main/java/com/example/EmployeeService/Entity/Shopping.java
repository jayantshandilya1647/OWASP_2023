package com.example.EmployeeService.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shopping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PRODUCT_ID")
    private Long productId;

    @Column(name="PRODUCT_NAME")
    private String productName;

 /*   @Column(name="PRODUCT_IMAGE")
    private String productImage;*/

    @Column(name="USER_ID")
    private Long userId;

    @Column(name="USER_NAME")
    private String UserName;

    @Column(name="USER_PHONE_NUMBER")
    private String phoneNumber;

    @Column(name="USER_EMAIL_ADDRESS")
    private String emailId;
}
