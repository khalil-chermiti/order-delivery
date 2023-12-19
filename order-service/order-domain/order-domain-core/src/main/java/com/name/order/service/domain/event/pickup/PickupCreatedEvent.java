package com.name.order.service.domain.event.pickup;

import com.name.order.service.domain.entity.Pickup;

import java.time.ZonedDateTime;

public class PickupCreatedEvent extends PickupEvent {
    public PickupCreatedEvent(Pickup pickup, ZonedDateTime createdAt) {
        super(pickup, createdAt);
    }
}
