package com.name.order.service.domain.event.pickup;

import com.name.domain.event.DomainEvent;
import com.name.order.service.domain.entity.Pickup;

import java.time.ZonedDateTime;

public class PickupEvent implements DomainEvent<Pickup> {
    private final Pickup pickup;
    private final ZonedDateTime createdAt;

    public PickupEvent(Pickup pickup, ZonedDateTime createdAt) {
        this.pickup = pickup;
        this.createdAt = createdAt;
    }

    public Pickup getPickup() {
        return pickup;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
