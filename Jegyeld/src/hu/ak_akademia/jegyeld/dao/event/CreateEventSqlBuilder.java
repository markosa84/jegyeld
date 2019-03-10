package hu.ak_akademia.jegyeld.dao.event;

import hu.ak_akademia.jegyeld.dao.SqlBuilder;

public class CreateEventSqlBuilder implements SqlBuilder {

    @Override
    public String build() {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO event ( ");
        sql.append("    event_id, ");
        sql.append("    event_name, ");
        sql.append("    event_description, ");
        sql.append("    event_location, ");
        sql.append("    image_location, ");
        sql.append("    event_start, ");
        sql.append("    event_end, ");
        sql.append("    total_seats, ");
        sql.append("    free_seats ");
        sql.append(") VALUES ( ");
        sql.append("    nextval('event_seq'), ");
        sql.append("    ?, ");
        sql.append("    ?, ");
        sql.append("    ?, ");
        sql.append("    ?, ");
        sql.append("    ?, ");
        sql.append("    ?, ");
        sql.append("    ?, ");
        sql.append("    ? ");
        sql.append(") ");
        return sql.toString();
    }

}