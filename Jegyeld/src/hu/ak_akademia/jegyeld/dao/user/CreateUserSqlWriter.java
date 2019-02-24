package hu.ak_akademia.jegyeld.dao.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.jegyeld.dao.SqlUtil;
import hu.ak_akademia.jegyeld.dao.SqlWriter;
import hu.ak_akademia.jegyeld.dto.User;

public class CreateUserSqlWriter implements SqlWriter {

    private final User user;

    public CreateUserSqlWriter(User user) {
        this.user = user;
    }

    @Override
    public void write(PreparedStatement preparedStatement) throws SQLException {
        int i = 1;
        preparedStatement.setString(i++, user.getFirstName());
        preparedStatement.setString(i++, user.getLastName());
        preparedStatement.setString(i++, user.getAddress());
        preparedStatement.setString(i++, user.getPhone());
        preparedStatement.setString(i++, user.getEmail());
        preparedStatement.setString(i++, user.getPassword());
        preparedStatement.setDate(i++, SqlUtil.toDate(user.getDateOfBirth()));
    }

}
