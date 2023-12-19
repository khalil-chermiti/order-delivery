package com.name.order.service.domain.valueObject;

import com.name.domain.valueObject.BaseId;

import java.util.UUID;

public class OrderId extends BaseId<UUID> {
    protected OrderId(UUID value) {
        super(value);
    }
}
