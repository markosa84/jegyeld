package hu.ak_akademia.jegyeld.dao.event;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.jegyeld.dao.SqlWriter;
import hu.ak_akademia.jegyeld.dto.Event;

public class UpdateEventSqlWriter implements SqlWriter {

    private final Event event;

    public UpdateEventSqlWriter(Event event) {
        this.event = event;
    }

    @Override
    public void write(PreparedStatement preparedStatement) throws SQLException {
        int i = 1;
        preparedStatement.setInt(i++, event.getFreeSeats());
        preparedStatement.setInt(i++, event.getId());
    }

}