package com.name.order.service.domain.valueObject;

import com.name.order.service.domain.exception.OrderDomainErrorMessages;
import com.name.order.service.domain.exception.OrderDomainException;

public class Weight {
    private Float value ;

    public void checkIfWeightAcceptable() {
        if (value < 0 || value > 500)
            throw new OrderDomainException(OrderDomainErrorMessages.UNSUPPORTED_WEIGHT);
    }
}
