package hu.ak_akademia.jegyeld.dto;

import java.util.Date;

public class Event {

    private int id;
    private String name;
    private String description;
    private String location;
    private Date start;
    private Date end;
    private int totalSeats;
    private int freeSeats;
    private Date created;
    private Date updated;
    private Status status;

    private Event(int id, String name, String description, String location, Date start, Date end, int totalSeats, int freeSeats, Date created, Date updated, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.start = start;
        this.end = end;
        this.totalSeats = totalSeats;
        this.freeSeats = freeSeats;
        this.created = created;
        this.updated = updated;
        this.status = status;
    }

    public static class Builder {
        private int id;
        private String name;
        private String description;
        private String location;
        private Date start;
        private Date end;
        private int totalSeats;
        private int freeSeats;
        private Date created;
        private Date updated;
        private Status status;

        public Builder id(int id) {
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

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder startDate(Date start) {
            this.start = start;
            return this;
        }

        public Builder endDate(Date end) {
            this.end = end;
            return this;
        }

        public Builder totalSeats(int totalSeats) {
            this.totalSeats = totalSeats;
            return this;
        }

        public Builder freeSeats(int freeSeats) {
            this.freeSeats = freeSeats;
            return this;
        }

        public Builder createdDate(Date created) {
            this.created = created;
            return this;
        }

        public Builder updatedDate(Date updated) {
            this.updated = updated;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Event build() {
            checkPreConditions();
            return new Event(id, name, description, location, start, end, totalSeats, freeSeats, created, updated, status);
        }

        private void checkPreConditions() {
            if (id <= 0) {
                throw new IllegalArgumentException("Az esemény azonosítója nem lehet 0, vagy annál kisebb értékű!");
            }
            if (name == null) {
                throw new IllegalArgumentException("Az esemény nevének megadása kötelező!");
            }
            if (start == null || end == null) {
                throw new IllegalArgumentException("Az esemény kezdetének és befejezésének dátuma is kötelezően definiálandó!");
            }
            if (totalSeats < 0 || freeSeats < 0) {
                throw new IllegalArgumentException("Az ülőhelyek száma nem lehet 0-nál kisebb!");
            }
            if (created == null || updated == null) {
                throw new IllegalArgumentException("Az esemény létrehozásának és frissítésének definiálása is kötelező!");
            }
            if (status == null) {
                throw new IllegalArgumentException("Az esemény státuszának definiálása kötelező!");
            }

        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
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
        result = prime * result + id;
        result = prime * result + (created == null ? 0 : created.hashCode());
        result = prime * result + (description == null ? 0 : description.hashCode());
        result = prime * result + (end == null ? 0 : end.hashCode());
        result = prime * result + freeSeats;
        result = prime * result + (location == null ? 0 : location.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (start == null ? 0 : start.hashCode());
        result = prime * result + (status == null ? 0 : status.hashCode());
        result = prime * result + totalSeats;
        result = prime * result + (updated == null ? 0 : updated.hashCode());
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        Event other = (Event) obj;
        if (id != other.id) {
            return false;
        }
        if (created == null) {
            if (other.created != null) {
                return false;
            }
        } else if (!created.equals(other.created)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (end == null) {
            if (other.end != null) {
                return false;
            }
        } else if (!end.equals(other.end)) {
            return false;
        }
        if (freeSeats != other.freeSeats) {
            return false;
        }
        if (location == null) {
            if (other.location != null) {
                return false;
            }
        } else if (!location.equals(other.location)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (start == null) {
            if (other.start != null) {
                return false;
            }
        } else if (!start.equals(other.start)) {
            return false;
        }
        if (status != other.status) {
            return false;
        }
        if (totalSeats != other.totalSeats) {
            return false;
        }
        if (updated == null) {
            if (other.updated != null) {
                return false;
            }
        } else if (!updated.equals(other.updated)) {
            return false;
        }
        return true;
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
        builder.append(", location=");
        builder.append(location);
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