package hu.ak_akademia.jegyeld.dao.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.jegyeld.dao.SqlWriter;

public class GetUserByEmailSqlWriter implements SqlWriter {

    private final String email;

    public GetUserByEmailSqlWriter(String email) {
        this.email = email;
    }

    @Override
    public void write(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, email);
    }

}