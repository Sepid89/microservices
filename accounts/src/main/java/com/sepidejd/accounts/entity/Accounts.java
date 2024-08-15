package com.sepidejd.accounts.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.service.annotation.GetExchange;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Accounts extends BaseEntity{

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private Long accountId;

    @Column(name = "customer_id")
    private Long customerId;



}
