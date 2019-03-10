package hu.ak_akademia.jegyeld.dao.event;

import hu.ak_akademia.jegyeld.dao.SqlBuilder;
import hu.ak_akademia.jegyeld.dto.Status;

public class GetEventByIdSqlBuilder implements SqlBuilder {

    @Override
    public String build() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("    event_id, ");
        sql.append("    event_name, ");
        sql.append("    event_description, ");
        sql.append("    event_location, ");
        sql.append("    image_location, ");
        sql.append("    event_start, ");
        sql.append("    event_end, ");
        sql.append("    total_seats, ");
        sql.append("    free_seats, ");
        sql.append("    created_at, ");
        sql.append("    updated_at, ");
        sql.append("    status ");
        sql.append("FROM ");
        sql.append("    event ");
        sql.append("WHERE ");
        sql.append("    event_id = ? ");
        sql.append("    AND status = '")
                .append(Status.ACTIVE.getCode())
                .append("' ");
        return sql.toString();
    }

}