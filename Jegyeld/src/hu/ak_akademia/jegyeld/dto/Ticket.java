package hu.ak_akademia.jegyeld.dto;

import java.util.Date;

public class Ticket {

	private int id;
	private int price;
	private int seatNumber;
	private int eventId;
	private int userId;
	private Date createdAt;
	private Date updatedAt;
	private Status status;

	private Ticket(int id, int price, int seatNumber, int eventId, int userId, Date createdAt, Date updatedAt, Status status) {
		this.id = id;
		this.price = price;
		this.seatNumber = seatNumber;
		this.eventId = eventId;
		this userId = userId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
	}

	public static class Builder {
		private int id;
		private int price;
		private int seatNumber;
		private int eventId;
		private int userId;
		private Date createdAt;
		private Date updatedAt;
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

		public Builder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}

		public Builder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}

		public Builder status(Status status) {
			this.status = status;
			return this;
		}

		public Build build() {
			validate();
			return new Ticket(id, price, seatNumber, eventId, userId, createdAt, updatedAt, status);
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
			if (createdAt == null || updatedAt == null) {
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ticket id: ");
		builder.append(id);
		builder.append(", Price: ");
		builder.append(price);
		builder.append(", Seat number: ");
		builder.append(seatNumber);
		builder.append(", Event id: ");
		builder.append(eventId);
		builder.append(", User id: ");
		builder.append(userId);
		builder.append(", Created at: ");
		builder.append(createdAt);
		builder.append(", Updated at: ");
		builder.append(updatedAt);
		builder.append(", Status: ");
		builder.append(status);
		return builder.toString();
	}

}
