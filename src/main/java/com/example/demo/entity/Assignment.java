package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Participant giver;

    @ManyToOne
    private Participant receiver;

    private String deliveryDate; // Para modo clásico o cumpleaños

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Participant getGiver() { return giver; }
    public void setGiver(Participant giver) { this.giver = giver; }
    public Participant getReceiver() { return receiver; }
    public void setReceiver(Participant receiver) { this.receiver = receiver; }
    public String getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(String deliveryDate) { this.deliveryDate = deliveryDate; }
}
