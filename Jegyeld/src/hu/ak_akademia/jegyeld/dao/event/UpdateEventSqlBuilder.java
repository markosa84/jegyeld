package hu.ak_akademia.jegyeld.dao.event;

import hu.ak_akademia.jegyeld.dao.SqlBuilder;

public class UpdateEventSqlBuilder implements SqlBuilder {

    @Override
    public String build() {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ");
        sql.append("    event ");
        sql.append("SET ");
        sql.append("    free_seats = ?, ");
        sql.append("    updated_at = NOW() ");
        sql.append("WHERE ");
        sql.append("    event_id   = ?");
        return sql.toString();
    }

}