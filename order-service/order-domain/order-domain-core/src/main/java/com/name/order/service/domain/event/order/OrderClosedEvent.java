package com.name.order.service.domain.event.order;

import com.name.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderClosedEvent extends OrderEvent{
    public OrderClosedEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
