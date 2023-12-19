package com.name.order.service.domain.event.order;

import com.name.domain.event.DomainEvent;
import com.name.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderEvent implements DomainEvent<Order> {
    private final Order order;
    private final ZonedDateTime createdAt;

    public OrderEvent(Order order, ZonedDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
