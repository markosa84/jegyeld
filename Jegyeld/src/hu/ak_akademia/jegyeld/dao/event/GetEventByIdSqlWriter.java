package hu.ak_akademia.jegyeld.dao.event;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.jegyeld.dao.SqlWriter;

public class GetEventByIdSqlWriter implements SqlWriter {

    private final int id;

    public GetEventByIdSqlWriter(int id) {
        this.id = id;
    }

    @Override
    public void write(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
    }

}