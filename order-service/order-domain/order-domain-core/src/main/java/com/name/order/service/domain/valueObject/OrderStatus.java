package com.name.order.service.domain.valueObject;

import java.util.WeakHashMap;

public enum OrderStatus {
    CREATED, PICKED, OUT_FOR_DELIVERY, DELIVERED, PAID,
    RETURNING, RETURNED,
    DELETED, FAILED, CANCELED;
}
