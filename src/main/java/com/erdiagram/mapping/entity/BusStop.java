package com.erdiagram.mapping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bus_stop")
public class BusStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "stop_order", nullable = false)
    private String stopOrder;

    @ManyToOne
    @JoinColumn(name = "stop_id")
    private Stop stop;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

}