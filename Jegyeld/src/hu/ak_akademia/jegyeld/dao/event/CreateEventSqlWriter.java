package hu.ak_akademia.jegyeld.dao.event;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.jegyeld.dao.SqlUtil;
import hu.ak_akademia.jegyeld.dao.SqlWriter;
import hu.ak_akademia.jegyeld.dto.Event;

public class CreateEventSqlWriter implements SqlWriter {

    private final Event event;

    public CreateEventSqlWriter(Event event) {
        this.event = event;
    }

    @Override
    public void write(PreparedStatement preparedStatement) throws SQLException {
        int i = 1;
        preparedStatement.setString(i++, event.getName());
        preparedStatement.setString(i++, event.getDescription());
        preparedStatement.setString(i++, event.getEventLocation());
        preparedStatement.setString(i++, event.getImageLocation());
        preparedStatement.setTimestamp(i++, SqlUtil.toTimeStamp(event.getStart()));
        preparedStatement.setTimestamp(i++, SqlUtil.toTimeStamp(event.getEnd()));
        preparedStatement.setInt(i++, event.getTotalSeats());
        preparedStatement.setInt(i++, event.getFreeSeats());
    }

}