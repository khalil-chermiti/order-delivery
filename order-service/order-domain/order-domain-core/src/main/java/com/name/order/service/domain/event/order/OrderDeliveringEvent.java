package com.name.order.service.domain.event.order;

import com.name.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderDeliveringEvent extends OrderEvent {
    public OrderDeliveringEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
