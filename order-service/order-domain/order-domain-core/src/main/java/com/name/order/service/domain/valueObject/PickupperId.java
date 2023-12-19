package com.name.order.service.domain.valueObject;

import com.name.domain.valueObject.BaseId;

import java.util.UUID;

public class PickupperId extends BaseId<UUID> {
    protected PickupperId(UUID value) {
        super(value);
    }
}
