package hu.ak_akademia.jegyeld.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket {

    private Integer id;
    private Integer price;
    private Integer seatNumber;
    private Integer eventId;
    private Integer userId;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Status status;

    private Ticket(Integer id, Integer price, Integer seatNumber, Integer eventId, Integer userId, LocalDateTime created, LocalDateTime updated, Status status) {
        this.id = id;
        this.price = price;
        this.seatNumber = seatNumber;
        this.eventId = eventId;
        this.userId = userId;
        this.created = created;
        this.updated = updated;
        this.status = status;
    }

    public static class Builder {
        private Integer id;
        private Integer price;
        private Integer seatNumber;
        private Integer eventId;
        private Integer userId;
        private LocalDateTime created;
        private LocalDateTime updated;
        private Status status;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder price(Integer price) {
            this.price = price;
            return this;
        }

        public Builder seatNumber(Integer seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public Builder eventId(Integer eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder created(LocalDateTime createdAt) {
            this.created = createdAt;
            return this;
        }

        public Builder updated(LocalDateTime updatedAt) {
            this.updated = updatedAt;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Ticket build() {
            return new Ticket(id, price, seatNumber, eventId, userId, created, updated, status);
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(created, eventId, id, price, seatNumber, status, updated, userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) obj;
        return Objects.equals(created, other.created) && Objects.equals(eventId, other.eventId) && Objects.equals(id, other.id) && Objects.equals(price, other.price)
                && Objects.equals(seatNumber, other.seatNumber) && status == other.status && Objects.equals(updated, other.updated) && Objects.equals(userId, other.userId);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Ticket [id=");
        builder.append(id);
        builder.append(", price=");
        builder.append(price);
        builder.append(", seatNumber=");
        builder.append(seatNumber);
        builder.append(", eventId=");
        builder.append(eventId);
        builder.append(", userId=");
        builder.append(userId);
        builder.append(", created=");
        builder.append(created);
        builder.append(", updated=");
        builder.append(updated);
        builder.append(", status=");
        builder.append(status);
        builder.append("]");
        return builder.toString();
    }

}