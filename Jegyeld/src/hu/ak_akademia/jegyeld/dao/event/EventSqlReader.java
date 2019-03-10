package hu.ak_akademia.jegyeld.dao.event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.jegyeld.dao.SqlReader;
import hu.ak_akademia.jegyeld.dao.SqlUtil;
import hu.ak_akademia.jegyeld.dto.Event;
import hu.ak_akademia.jegyeld.dto.Status;

public class EventSqlReader implements SqlReader<Event> {

    @Override
    public List<Event> read(ResultSet resultSet) throws SQLException {
        List<Event> events = new ArrayList<>();
        while (resultSet.next()) {
            Integer id = SqlUtil.getInteger(resultSet, "event_id");
            String name = resultSet.getString("event_name");
            String description = resultSet.getString("event_description");
            String eventLocation = resultSet.getString("event_location");
            String imageLocation = resultSet.getString("image_location");
            LocalDateTime start = SqlUtil.toLocalDateTime(resultSet.getTimestamp("event_start"));
            LocalDateTime end = SqlUtil.toLocalDateTime(resultSet.getTimestamp("event_end"));
            Integer totalSeats = SqlUtil.getInteger(resultSet, "total_seats");
            Integer freeSeats = SqlUtil.getInteger(resultSet, "free_seats");
            LocalDateTime created = SqlUtil.toLocalDateTime(resultSet.getTimestamp("created_at"));
            LocalDateTime updated = SqlUtil.toLocalDateTime(resultSet.getTimestamp("updated_at"));
            Status status = Status.getByCode(resultSet.getString("status"));

            Event event = new Event.Builder().id(id)
                    .name(name)
                    .description(description)
                    .eventLocation(eventLocation)
                    .imageLocation(imageLocation)
                    .startDate(start)
                    .endDate(end)
                    .totalSeats(totalSeats)
                    .freeSeats(freeSeats)
                    .createdDate(created)
                    .updatedDate(updated)
                    .status(status)
                    .build();
            events.add(event);
        }
        return events;
    }

}