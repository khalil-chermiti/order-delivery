package com.name.order.service.domain.valueObject;

import com.name.domain.valueObject.BaseId;

import java.util.UUID;

public class PickupAddressId extends BaseId<UUID> {
    protected PickupAddressId(UUID value) {
        super(value);
    }
}
