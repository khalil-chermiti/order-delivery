package com.name.order.service.domain.event.order;


import com.name.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderDeliveredEvent extends OrderEvent {
    public OrderDeliveredEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
