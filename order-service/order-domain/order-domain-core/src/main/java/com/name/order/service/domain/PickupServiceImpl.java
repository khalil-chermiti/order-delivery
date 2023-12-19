package com.name.order.service.domain;

import com.name.order.service.domain.entity.Order;
import com.name.order.service.domain.entity.Pickup;
import com.name.order.service.domain.event.pickup.PickupCancelledEvent;
import com.name.order.service.domain.event.pickup.PickupCreatedEvent;
import com.name.order.service.domain.event.pickup.PickupPickedEvent;
import com.name.order.service.domain.valueObject.OrderStatus;
import com.name.order.service.domain.valueObject.PickupId;
import com.name.order.service.domain.valueObject.PickupperId;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PickupServiceImpl implements PickupService {
    @Override
    public PickupCreatedEvent validateAndInitiatePickup(Pickup pickup) {
        pickup.initPickup();

        // set pickup id for each order
        pickup.getOrders()
            .forEach(order -> order.setPickupId(new PickupId(pickup.getId())));

        log.info("Pickup initiated: {}", pickup.getId());

        return new PickupCreatedEvent(pickup, pickup.getCreatedAt());
    }

    @Override
    public PickupPickedEvent pickPickup(Pickup pickup, PickupperId pickupperId) {
        pickup.pickUp(pickupperId);

        // mark all orders associated with this pickup as picked
        pickup.getOrders().forEach(order -> order.pickOrder(pickupperId));

        log.info("Pickup picked: {}", pickup.getId());

        return new PickupPickedEvent(pickup, pickup.getUpdatedAt());
    }

    @Override
    public PickupCancelledEvent cancelPickup(Pickup pickup) {
        pickup.cancelPickup();

        // Cancel all orders associated with this pickup
        pickup.getOrders().forEach(order -> {
            if (order.getOrderStatus() != OrderStatus.DELIVERED) order.cancelOrder();
        });

        log.info("Pickup cancelled: {}", pickup.getId());

        return new PickupCancelledEvent(pickup, pickup.getUpdatedAt());
    }
}
