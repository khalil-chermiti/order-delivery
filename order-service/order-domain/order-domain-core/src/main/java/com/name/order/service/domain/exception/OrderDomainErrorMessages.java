package com.name.order.service.domain.exception;

public class OrderDomainErrorMessages {
    public static final String NO_BUSINESS_ADDRESS = "business address not found";
    public static final String UNSUPPORTED_WEIGHT = "weight is no supported";
    public static final String CAN_NOT_UPDATE_ORDER_STATUS = "can not update order status at this state";
    public static final String CAN_NOT_UPDATE_PICKUP_STATUS = "can not update pickup status at this state";
    public static final String PICKUP_HAS_NO_ORDER = "a pickup must at least have one order";
}
