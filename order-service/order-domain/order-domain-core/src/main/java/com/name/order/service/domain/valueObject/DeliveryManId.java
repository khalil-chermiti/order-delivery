package com.name.order.service.domain.valueObject;

import com.name.domain.valueObject.BaseId;

import java.util.UUID;

public class DeliveryManId extends BaseId<UUID> {
    protected DeliveryManId(UUID value) {
        super(value);
    }
}
