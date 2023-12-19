package com.name.order.service.domain;

import com.name.order.service.domain.entity.Pickup;
import com.name.order.service.domain.event.pickup.PickupCancelledEvent;
import com.name.order.service.domain.event.pickup.PickupCreatedEvent;
import com.name.order.service.domain.event.pickup.PickupPickedEvent;
import com.name.order.service.domain.valueObject.PickupperId;

public interface PickupService {
    // create pick up
    PickupCreatedEvent validateAndInitiatePickup(Pickup pickup);

    // pick pickup
    PickupPickedEvent pickPickup(Pickup pickup , PickupperId pickupperId);

    // cancel pickup
    PickupCancelledEvent cancelPickup(Pickup pickup);
}
