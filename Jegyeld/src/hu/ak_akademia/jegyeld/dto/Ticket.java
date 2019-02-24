package hu.ak_akademia.jegyeld.dto;

import java.util.Date;

public class Ticket {

    private int id;
    private int price;
    private int seatNumber;
    private int eventId;
    private int userId;
    private Date created;
    private Date updated;
    private Status status;

    private Ticket(int id, int price, int seatNumber, int eventId, int userId, Date created, Date updated, Status status) {
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
        private int id;
        private int price;
        private int seatNumber;
        private int eventId;
        private int userId;
        private Date created;
        private Date updated;
        private Status status;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder price(int price) {
            this.price = price;
            return this;
        }

        public Builder seatNumber(int seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public Builder eventId(int eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder userId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder created(Date createdAt) {
            this.created = createdAt;
            return this;
        }

        public Builder updated(Date updatedAt) {
            this.updated = updatedAt;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Ticket build() {
            validate();
            return new Ticket(id, price, seatNumber, eventId, userId, created, updated, status);
        }

        private void validate() {
            if (id <= 0) {
                throw new IllegalArgumentException("A jegy azonosítójának minimum 1-el kell kezdődnie!");
            }
            if (price == 0) {
                throw new IllegalArgumentException("A jegy árának megadása kötelező!");
            }
            if (seatNumber <= 0) {
                throw new IllegalArgumentException("Minimum 1 ülőhelyet ki kell választania!");
            }
            if (eventId <= 0) {
                throw new IllegalArgumentException("Kötelező kiválasztania egy eseményt");
            }
            if (userId <= 0) {
                throw new IllegalArgumentException("A felhasználó azonosítója nem lehet 1-nél kisebb!");
            }
            if (created == null || updated == null) {
                throw new IllegalArgumentException("A jegy létrehozása és frissítése mezőt kötelező kitöltenie!");
            }
            if (status == null) {
                throw new IllegalArgumentException("Kötelező megadnia a jegy státuszát!");
            }
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
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
        final int prime = 31;
        int result = 1;
        result = prime * result + (created == null ? 0 : created.hashCode());
        result = prime * result + eventId;
        result = prime * result + id;
        result = prime * result + price;
        result = prime * result + seatNumber;
        result = prime * result + (status == null ? 0 : status.hashCode());
        result = prime * result + (updated == null ? 0 : updated.hashCode());
        result = prime * result + userId;
        return result;
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
        if (created == null) {
            if (other.created != null) {
                return false;
            }
        } else if (!created.equals(other.created)) {
            return false;
        }
        if (eventId != other.eventId) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (price != other.price) {
            return false;
        }
        if (seatNumber != other.seatNumber) {
            return false;
        }
        if (status != other.status) {
            return false;
        }
        if (updated == null) {
            if (other.updated != null) {
                return false;
            }
        } else if (!updated.equals(other.updated)) {
            return false;
        }
        if (userId != other.userId) {
            return false;
        }
        return true;
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