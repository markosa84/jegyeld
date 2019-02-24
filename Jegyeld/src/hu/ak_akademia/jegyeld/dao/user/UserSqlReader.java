package hu.ak_akademia.jegyeld.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.jegyeld.dao.SqlReader;
import hu.ak_akademia.jegyeld.dao.SqlUtil;
import hu.ak_akademia.jegyeld.dto.Status;
import hu.ak_akademia.jegyeld.dto.User;

public class UserSqlReader implements SqlReader<User> {

    @Override
    public List<User> read(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            Integer id = SqlUtil.getInteger(resultSet, "user_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String address = resultSet.getString("address");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String password = resultSet.getString("password");
            LocalDate dateOfBirth = SqlUtil.toLocalDate(resultSet.getDate("date_of_birth"));
            LocalDateTime created = SqlUtil.toLocalDateTime(resultSet.getTimestamp("created_at"));
            LocalDateTime updated = SqlUtil.toLocalDateTime(resultSet.getTimestamp("updated_at"));
            Status status = Status.getByCode(resultSet.getString("status"));

            User user = new User.Builder().id(id)
                    .firstName(firstName)
                    .lastName(lastName)
                    .address(address)
                    .email(email)
                    .phone(phone)
                    .password(password)
                    .dateOfBirth(dateOfBirth)
                    .created(created)
                    .updated(updated)
                    .status(status)
                    .build();
            users.add(user);
        }
        return users;
    }

}
