package com.name.order.service.domain;

import com.name.domain.event.EmptyEvent;
import com.name.order.service.domain.entity.Order;
import com.name.order.service.domain.event.order.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order) {
        order.initOrder();

        log.info("Order {} initiated", order.getId());

        return new OrderCreatedEvent(order, order.getCreatedAt());
    }

    @Override
    public EmptyEvent deleteOrder(Order order) {
        order.deleteOrder();

        log.info("Order {} deleted", order.getId());

        return EmptyEvent.INSTANCE;
    }

    @Override
    public OrderDeliveringEvent markOrderAsBeingDelivered(Order order) {
        order.deliverOrder();

        log.info("Order {} is being delivered", order.getId());

        return new OrderDeliveringEvent(order, order.getCreatedAt());
    }

    @Override
    public OrderDeliveredEvent markOrderAsDelivered(Order order) {
        order.orderDelivered();

        log.info("Order {} delivered", order.getId());

        return new OrderDeliveredEvent(order, order.getCreatedAt());
    }

    @Override
    public OrderCancelledEvent cancelOrder(Order order) {
        order.cancelOrder();

        log.info("Order {} cancelled", order.getId());

        return new OrderCancelledEvent(order, order.getCreatedAt());
    }

    @Override
    public OrderClosedEvent markOrderDeliveryAsFailed(Order order, String reason) {
        order.orderFailed(reason);

        log.info("Order {} delivery failed", order.getId());

        return new OrderClosedEvent(order, order.getCreatedAt());
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.payOrder();

        log.info("Order {} paid", order.getId());

        return new OrderPaidEvent(order, order.getCreatedAt());
    }

    @Override
    public OrderReturningEvent markOrderAsReturning(Order order) {
        order.returningOrder();

        log.info("Order {} is returning", order.getId());

        return new OrderReturningEvent(order, order.getCreatedAt());
    }

    @Override
    public OrderReturnedEvent returnOrder(Order order) {
        order.orderReturned();

        log.info("Order {} returned", order.getId());

        return new OrderReturnedEvent(order, order.getCreatedAt());
    }
}
