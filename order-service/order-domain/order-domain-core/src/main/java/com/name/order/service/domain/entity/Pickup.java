package com.name.order.service.domain.entity;

import com.name.domain.entity.AggregateRoot;
import com.name.domain.exception.DomainException;
import com.name.order.service.domain.exception.OrderDomainErrorMessages;
import com.name.order.service.domain.exception.OrderDomainException;
import com.name.order.service.domain.valueObject.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pickup extends AggregateRoot<UUID> {
    private BusinessId businessId;
    private PickupperId pickupperId;
    private List<OrderId> orders;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private PickupAddressId pickupAddressId;
    private ZonedDateTime pickupDate;
    private String pickupPhone;
    private PickupStatus pickupStatus;
    private List<String> errorMessages;

    private Pickup(Builder builder) {
        businessId = builder.businessId;
        pickupperId = builder.pickupperId;
        orders = builder.orders;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        pickupAddressId = builder.pickupAddressId;
        pickupDate = builder.pickupDate;
        pickupPhone = builder.pickupPhone;
        errorMessages = builder.errorMessages;
    }

    public static final class Builder {
        private BusinessId businessId;
        private PickupperId pickupperId;
        private List<OrderId> orders;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private PickupAddressId pickupAddressId;
        private ZonedDateTime pickupDate;
        private String pickupPhone;
        private List<String> errorMessages;

        public Builder() {
        }

        public Builder setBusinessId(BusinessId val) {
            businessId = val;
            return this;
        }

        public Builder setPickupperId(PickupperId val) {
            pickupperId = val;
            return this;
        }

        public Builder setOrders(List<OrderId> val) {
            orders = val;
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

        public Builder setPickupAddressId(PickupAddressId val) {
            pickupAddressId = val;
            return this;
        }

        public Builder setPickupDate(ZonedDateTime val) {
            pickupDate = val;
            return this;
        }

        public Builder setPickupPhone(String val) {
            pickupPhone = val;
            return this;
        }

        public Builder setErrorMessages() {
            errorMessages = new ArrayList<>();
            return this;
        }

        public Pickup build() {
            return new Pickup(this);
        }
    }

    public BusinessId getBusinessId() {
        return businessId;
    }

    public void setBusinessId(BusinessId businessId) {
        this.businessId = businessId;
    }

    public PickupperId getPickupperId() {
        return pickupperId;
    }

    public void setPickupperId(PickupperId pickupperId) {
        this.pickupperId = pickupperId;
    }

    public List<OrderId> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderId> orders) {
        this.orders = orders;
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

    public PickupAddressId getPickupAddressId() {
        return pickupAddressId;
    }

    public void setPickupAddressId(PickupAddressId pickupAddressId) {
        this.pickupAddressId = pickupAddressId;
    }

    public ZonedDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(ZonedDateTime pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getPickupPhone() {
        return pickupPhone;
    }

    public void setPickupPhone(String pickupPhone) {
        this.pickupPhone = pickupPhone;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public PickupStatus getPickupStatus() {
        return pickupStatus;
    }

    public void setPickupStatus(PickupStatus pickupStatus) {
        this.pickupStatus = pickupStatus;
    }

    // init pickup
    public void initPickup() {
        validatePickup();
        setId(UUID.randomUUID());
        setPickupStatus(PickupStatus.CREATED);
        setCreatedAt(getCurrentZonedDateTime());
        setUpdatedAt(getCurrentZonedDateTime());
        setErrorMessages(new ArrayList<>());
    }

    // pick up pickup
    public void pickUp() {
        if (pickupStatus == PickupStatus.CREATED) {
            setUpdatedAt(getCurrentZonedDateTime());
            setPickupStatus(PickupStatus.PICKED);
        } else throw new OrderDomainException(OrderDomainErrorMessages.CAN_NOT_UPDATE_PICKUP_STATUS);
    }

    // cancel pickup
    public void cancelPickup() {
        if (pickupStatus == PickupStatus.PICKED || pickupStatus == PickupStatus.DELIVERING) {
            setUpdatedAt(getCurrentZonedDateTime());
            setPickupStatus(PickupStatus.CANCELLED);
        } else throw new OrderDomainException(OrderDomainErrorMessages.CAN_NOT_UPDATE_PICKUP_STATUS);
    }

    private void validatePickup() {
        if(businessId == null)
            throw new DomainException(OrderDomainErrorMessages.NO_BUSINESS_ADDRESS);

        if(orders.isEmpty())
            throw new DomainException(OrderDomainErrorMessages.PICKUP_HAS_NO_ORDER);
    }

    private ZonedDateTime getCurrentZonedDateTime() {
        return ZonedDateTime.now(ZoneId.of("UTC"));
    }
}
