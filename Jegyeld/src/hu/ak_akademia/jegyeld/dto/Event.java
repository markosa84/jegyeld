package hu.ak_akademia.jegyeld.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class Event {

    private Integer id;
    private String name;
    private String description;
    private String eventLocation;
    private String imageLocation;
    private LocalDateTime start;
    private LocalDateTime end;
    private Integer totalSeats;
    private Integer freeSeats;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Status status;

    private Event(Integer id, String name, String description, String eventLocation, String imageLocation, LocalDateTime start, LocalDateTime end, Integer totalSeats, Integer freeSeats,
            LocalDateTime created, LocalDateTime updated, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.eventLocation = eventLocation;
        this.imageLocation = imageLocation;
        this.start = start;
        this.end = end;
        this.totalSeats = totalSeats;
        this.freeSeats = freeSeats;
        this.created = created;
        this.updated = updated;
        this.status = status;
    }

    public static class Builder {
        private Integer id;
        private String name;
        private String description;
        private String eventLocation;
        private String imageLocation;
        private LocalDateTime start;
        private LocalDateTime end;
        private Integer totalSeats;
        private Integer freeSeats;
        private LocalDateTime created;
        private LocalDateTime updated;
        private Status status;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder eventLocation(String eventLocation) {
            this.eventLocation = eventLocation;
            return this;
        }

        public Builder imageLocation(String imageLocation) {
            this.imageLocation = imageLocation;
            return this;
        }

        public Builder startDate(LocalDateTime start) {
            this.start = start;
            return this;
        }

        public Builder endDate(LocalDateTime end) {
            this.end = end;
            return this;
        }

        public Builder totalSeats(Integer totalSeats) {
            this.totalSeats = totalSeats;
            return this;
        }

        public Builder freeSeats(Integer freeSeats) {
            this.freeSeats = freeSeats;
            return this;
        }

        public Builder createdDate(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public Builder updatedDate(LocalDateTime updated) {
            this.updated = updated;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Event build() {
            return new Event(id, name, description, eventLocation, imageLocation, start, end, totalSeats, freeSeats, created, updated, status);
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(Integer freeSeats) {
        this.freeSeats = freeSeats;
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
        return Objects.hash(created, description, end, eventLocation, freeSeats, id, imageLocation, name, start, status, totalSeats, updated);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event other = (Event) obj;
        return Objects.equals(created, other.created) && Objects.equals(description, other.description) && Objects.equals(end, other.end) && Objects.equals(eventLocation, other.eventLocation)
                && Objects.equals(freeSeats, other.freeSeats) && Objects.equals(id, other.id) && Objects.equals(imageLocation, other.imageLocation) && Objects.equals(name, other.name)
                && Objects.equals(start, other.start) && status == other.status && Objects.equals(totalSeats, other.totalSeats) && Objects.equals(updated, other.updated);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Event [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", description=");
        builder.append(description);
        builder.append(", eventLocation=");
        builder.append(eventLocation);
        builder.append(", imageLocation=");
        builder.append(imageLocation);
        builder.append(", start=");
        builder.append(start);
        builder.append(", end=");
        builder.append(end);
        builder.append(", totalSeats=");
        builder.append(totalSeats);
        builder.append(", freeSeats=");
        builder.append(freeSeats);
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