package com.name.order.service.domain.entity;

import com.name.domain.entity.AggregateRoot;
import com.name.domain.exception.DomainException;
import com.name.domain.valueObject.Money;
import com.name.order.service.domain.valueObject.OrderStatus;
import com.name.order.service.domain.exception.OrderDomainErrorMessages;
import com.name.order.service.domain.exception.OrderDomainException;
import com.name.order.service.domain.valueObject.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.name.order.service.domain.valueObject.OrderStatus.*;

public class Order extends AggregateRoot<UUID> {
    private BusinessId businessId;
    private PickupId pickupId;
    private PickupperId pickupperId;
    private DeliveryManId deliveryManId;

    private Money price;
    private Weight weight;
    private Integer numberOfItems;
    private String description;

    private OrderStatus orderStatus;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Address clientAddress;
    private ZonedDateTime clientDeliveryDate;
    private String clientPhoneNumber;
    private List<String> errorMessages;

    private Order(Builder builder) {
        setId(builder.id.getValue());
        businessId = builder.businessId;
        pickupId = builder.pickupId;
        pickupperId = builder.pickupperId;
        deliveryManId = builder.deliveryManId;
        price = builder.price;
        weight = builder.weight;
        numberOfItems = builder.numberOfItems;
        description = builder.description;
        orderStatus = builder.orderStatus;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        clientAddress = builder.clientAddress;
        clientDeliveryDate = builder.clientDeliveryDate;
        clientPhoneNumber = builder.clientPhoneNumber;
        errorMessages = new ArrayList<>();
    }


    public BusinessId getBusinessId() {
        return businessId;
    }

    public void setBusinessId(BusinessId businessId) {
        this.businessId = businessId;
    }

    public PickupId getPickupId() {
        return pickupId;
    }

    public void setPickupId(PickupId pickupId) {
        this.pickupId = pickupId;
    }

    public PickupperId getPickupperId() {
        return pickupperId;
    }

    public void setPickupperId(PickupperId pickupperId) {
        this.pickupperId = pickupperId;
    }

    public DeliveryManId getDeliveryManId() {
        return deliveryManId;
    }

    public void setDeliveryManId(DeliveryManId deliveryManId) {
        this.deliveryManId = deliveryManId;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Address getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }

    public ZonedDateTime getClientDeliveryDate() {
        return clientDeliveryDate;
    }

    public void setClientDeliveryDate(ZonedDateTime clientDeliveryDate) {
        this.clientDeliveryDate = clientDeliveryDate;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public static final class Builder {
        private OrderId id;
        private BusinessId businessId;
        private PickupId pickupId;
        private PickupperId pickupperId;
        private DeliveryManId deliveryManId;
        private Money price;
        private Weight weight;
        private Integer numberOfItems;
        private String description;
        private OrderStatus orderStatus;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private Address clientAddress;
        private ZonedDateTime clientDeliveryDate;
        private String clientPhoneNumber;

        public Builder() {
        }

        public Builder setId(OrderId val) {
            id = val;
            return this;
        }

        public Builder setBusinessId(BusinessId val) {
            businessId = val;
            return this;
        }

        public Builder setPickupId(PickupId val) {
            pickupId = val;
            return this;
        }

        public Builder setPickupperId(PickupperId val) {
            pickupperId = val;
            return this;
        }

        public Builder setDeliveryManId(DeliveryManId val) {
            deliveryManId = val;
            return this;
        }

        public Builder setPrice(Money val) {
            price = val;
            return this;
        }

        public Builder setWeight(Weight val) {
            weight = val;
            return this;
        }

        public Builder setNumberOfItems(Integer val) {
            numberOfItems = val;
            return this;
        }

        public Builder setDescription(String val) {
            description = val;
            return this;
        }

        public Builder setOrderStatus(OrderStatus val) {
            orderStatus = val;
            return this;
        }

        public Builder setCreatedAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder setUpdatedAt(ZonedDateTime val) {
            updatedAt = val;
            return this;
        }

        public Builder setClientAddress(Address val) {
            clientAddress = val;
            return this;
        }

        public Builder setClientDeliveryDate(ZonedDateTime val) {
            clientDeliveryDate = val;
            return this;
        }

        public Builder setClientPhoneNumber(String val) {
            clientPhoneNumber = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    // init order
    public void initOrder() {
        setId(UUID.randomUUID());
        setOrderStatus(CREATED);
        setErrorMessages(new ArrayList<>());
        setCreatedAt(getCurrentZonedDateTime());
        setUpdatedAt(getCurrentZonedDateTime());
    }

    // pick order
    public void pickOrder(PickupperId pickupperId) {
        if (orderStatus == CREATED) {
            setUpdatedAt(getCurrentZonedDateTime());
            setOrderStatus(PICKED);
            setPickupperId(pickupperId);
        } else throw new OrderDomainException(OrderDomainErrorMessages.CAN_NOT_UPDATE_ORDER_STATUS);
    }

    // delete order
    public void deleteOrder() {
        if (orderStatus == CREATED) {
            setUpdatedAt(getCurrentZonedDateTime());
            setOrderStatus(DELETED);
        } else throw new OrderDomainException(OrderDomainErrorMessages.CAN_NOT_UPDATE_ORDER_STATUS);
    }


    public void cancelOrder() {
        if (orderStatus == PICKED || orderStatus == OUT_FOR_DELIVERY) {
            setUpdatedAt(getCurrentZonedDateTime());
            setOrderStatus(CANCELED);
        } else throw new OrderDomainException(OrderDomainErrorMessages.CAN_NOT_UPDATE_ORDER_STATUS);
    }


    // deliver order
    public void deliverOrder() {
        if (orderStatus == PICKED) {
            setUpdatedAt(getCurrentZonedDateTime());
            setOrderStatus(OUT_FOR_DELIVERY);
        } else throw new OrderDomainException(OrderDomainErrorMessages.CAN_NOT_UPDATE_ORDER_STATUS);
    }

    // order delivered
    public void orderDelivered() {
        if (orderStatus == OUT_FOR_DELIVERY) {
            setUpdatedAt(getCurrentZonedDateTime());
            setOrderStatus(DELIVERED);
        } else throw new OrderDomainException(OrderDomainErrorMessages.CAN_NOT_UPDATE_ORDER_STATUS);
    }

    public void payOrder() {
        if (orderStatus == DELIVERED) {
            setUpdatedAt(getCurrentZonedDateTime());
            setOrderStatus(PAID);
        } else throw new OrderDomainException(OrderDomainErrorMessages.CAN_NOT_UPDATE_ORDER_STATUS);
    }

    // returning order
    public void returningOrder() {
        if (orderStatus == FAILED || orderStatus == CANCELED) {
            setUpdatedAt(getCurrentZonedDateTime());
            setOrderStatus(RETURNING);
        } else throw new OrderDomainException(OrderDomainErrorMessages.CAN_NOT_UPDATE_ORDER_STATUS);
    }

    // order returned
    public void orderReturned() {
        if (orderStatus == RETURNING) {
            setUpdatedAt(getCurrentZonedDateTime());
            setOrderStatus(RETURNED);
        } else throw new OrderDomainException(OrderDomainErrorMessages.CAN_NOT_UPDATE_ORDER_STATUS);
    }

    // order failed
    public void orderFailed(String FailureReason) {
        if (orderStatus == OUT_FOR_DELIVERY) {
            setUpdatedAt(getCurrentZonedDateTime());
            setOrderStatus(FAILED);
            errorMessages.add(FailureReason);
        } else throw new OrderDomainException(OrderDomainErrorMessages.CAN_NOT_UPDATE_ORDER_STATUS);
    }

    private ZonedDateTime getCurrentZonedDateTime() {
        return ZonedDateTime.now(ZoneId.of("UTC"));
    }

    private void validateOrder() {
        if (businessId == null)
            throw new DomainException(OrderDomainErrorMessages.NO_BUSINESS_ADDRESS);
        weight.checkIfWeightAcceptable();
    }
}
