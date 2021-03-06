package hu.ak_akademia.jegyeld.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String password;
    private LocalDate dateOfBirth;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Status status;

    private User(Integer id, String firstName, String lastName, String address, String email, String phone, String password, LocalDate dateOfBirth, LocalDateTime created, LocalDateTime updated,
            Status status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.created = created;
        this.updated = updated;
        this.status = status;
    }

    public static class Builder {
        private Integer id;
        private String firstName;
        private String lastName;
        private String address;
        private String email;
        private String phone;
        private String password;
        private LocalDate dateOfBirth;
        private LocalDateTime created;
        private LocalDateTime updated;
        private Status status;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder created(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public Builder updated(LocalDateTime updated) {
            this.updated = updated;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public User build() {
            return new User(id, firstName, lastName, address, email, phone, password, dateOfBirth, created, updated, status);
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
        return Objects.hash(address, created, dateOfBirth, email, firstName, id, lastName, password, phone, status, updated);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        return Objects.equals(address, other.address) && Objects.equals(created, other.created) && Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(email, other.email)
                && Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
                && Objects.equals(phone, other.phone) && status == other.status && Objects.equals(updated, other.updated);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [id=");
        builder.append(id);
        builder.append(", firstName=");
        builder.append(firstName);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", address=");
        builder.append(address);
        builder.append(", email=");
        builder.append(email);
        builder.append(", phone=");
        builder.append(phone);
        builder.append(", password=");
        builder.append(password);
        builder.append(", dateOfBirth=");
        builder.append(dateOfBirth);
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