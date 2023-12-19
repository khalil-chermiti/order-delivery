package com.name.order.service.domain.valueObject;

import com.name.domain.valueObject.BaseId;

import java.util.UUID;

public class PickupId extends BaseId<UUID> {
    public PickupId(UUID value) {
        super(value);
    }
}
