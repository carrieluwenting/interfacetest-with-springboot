package com.carrie.lu.config.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "demo")
public class DemoEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;


    @Column(name = "traffic_id")
    private Integer trafficId;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "speed_in_mps", nullable = false)
    private String speedInMps;

    @Column(name = "traffic_level", nullable = false)
    private int trafficLevel;
}
