package com.name.order.service.domain;

import com.name.domain.event.EmptyEvent;
import com.name.order.service.domain.entity.Order;
import com.name.order.service.domain.event.order.*;

// TODO: segregate this interface into multiple interfaces
// Liskov: Interface Segregation Principle

public interface OrderService {
    // create order
    OrderCreatedEvent validateAndInitiateOrder(Order order);

    // delete order
    EmptyEvent deleteOrder(Order order);

    // deliver order
    OrderDeliveringEvent markOrderAsBeingDelivered(Order order);

    // order delivered
    OrderDeliveredEvent markOrderAsDelivered(Order order);

    // cancel order
    OrderCancelledEvent cancelOrder(Order order);

    // close order
    OrderClosedEvent markOrderDeliveryAsFailed(Order order, String reason);

    // pay order
    OrderPaidEvent payOrder(Order order);

    // returning order
    OrderReturningEvent markOrderAsReturning(Order order);

    // return order
    OrderReturnedEvent returnOrder(Order order);
}
