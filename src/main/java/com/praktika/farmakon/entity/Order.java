package com.praktika.farmakon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_preparations",
               joinColumns = @JoinColumn(name = "order_id"),
               inverseJoinColumns = @JoinColumn(name = "preparation_id"))
    private List<Preparation> preparations;

    @PrePersist
    protected void prePersist() {
        this.number = generateRandomUniqueLong();
    }

    private Long generateRandomUniqueLong() {
        UUID uuid = UUID.randomUUID();
        long longValue = uuid.getMostSignificantBits();
        return Math.abs(longValue);
    }
}

