package com.name.order.service.domain.valueObject;

import com.name.domain.valueObject.BaseId;

import java.util.UUID;

public class BusinessId extends BaseId<UUID> {
    protected BusinessId(UUID value) {
        super(value);
    }
}
