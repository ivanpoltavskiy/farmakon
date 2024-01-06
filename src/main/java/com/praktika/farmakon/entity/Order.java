package com.praktika.farmakon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderInfo")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long number;

    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @ManyToMany
    @JoinTable(name = "orders_preparations",
               joinColumns = @JoinColumn(name = "order_id"),
               inverseJoinColumns = @JoinColumn(name = "preparation_id"))
    private List<Preparation> preparations;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", number=" + number +
                ", completed=" + completed +
                ", userId=" + userId +
                ", preparations=" + preparations +
                '}';
    }

}

