package hu.ak_akademia.jegyeld.dto;

import java.time.LocalDateTime;

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
			validate();
			return new Ticket(id, price, seatNumber, eventId, userId, created, updated, status);
		}

		private void validate() {
			if (id == null) {
				throw new IllegalArgumentException("A jegy azonosítójának minimum 1-el kell kezdődnie!");
			}
			if (price == null) {
				throw new IllegalArgumentException("A jegy árának megadása kötelező!");
			}
			if (seatNumber == null) {
				throw new IllegalArgumentException("Minimum 1 ülőhelyet ki kell választania!");
			}
			if (eventId == null) {
				throw new IllegalArgumentException("Kötelező kiválasztania egy eseményt");
			}
			if (userId == null) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + (created == null ? 0 : created.hashCode());
		result = prime * result + (eventId == null ? 0 : eventId.hashCode());
		result = prime * result + (id == null ? 0 : id.hashCode());
		result = prime * result + (price == null ? 0 : price.hashCode());
		result = prime * result + (seatNumber == null ? 0 : seatNumber.hashCode());
		result = prime * result + (status == null ? 0 : status.hashCode());
		result = prime * result + (updated == null ? 0 : updated.hashCode());
		result = prime * result + (userId == null ? 0 : userId.hashCode());
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
		Ticket other = (Ticket) obj;
		if (created == null) {
			if (other.created != null) {
				return false;
			}
		} else if (!created.equals(other.created)) {
			return false;
		}
		if (eventId == null) {
			if (other.eventId != null) {
				return false;
			}
		} else if (!eventId.equals(other.eventId)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		if (seatNumber == null) {
			if (other.seatNumber != null) {
				return false;
			}
		} else if (!seatNumber.equals(other.seatNumber)) {
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
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Ticket [id=");
		builder2.append(id);
		builder2.append(", price=");
		builder2.append(price);
		builder2.append(", seatNumber=");
		builder2.append(seatNumber);
		builder2.append(", eventId=");
		builder2.append(eventId);
		builder2.append(", userId=");
		builder2.append(userId);
		builder2.append(", created=");
		builder2.append(created);
		builder2.append(", updated=");
		builder2.append(updated);
		builder2.append(", status=");
		builder2.append(status);
		builder2.append("]");
		return builder2.toString();
	}

}