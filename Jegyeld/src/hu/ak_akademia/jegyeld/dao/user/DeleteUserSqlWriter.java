package hu.ak_akademia.jegyeld.dao.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.jegyeld.dao.SqlWriter;

public class DeleteUserSqlWriter implements SqlWriter {

    private final int id;

    public DeleteUserSqlWriter(int id) {
        this.id = id;
    }

    @Override
    public void write(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
    }

}
