package com.springboot.order.entity;

import com.springboot.coffee.entity.Coffee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrderCoffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCoffeeId;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "COFFEE_ID")
    private Coffee coffee;

    @Column(nullable = false)
    private int quantity;
}
