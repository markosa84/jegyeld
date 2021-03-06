package hu.ak_akademia.jegyeld.dao.ticket;

import hu.ak_akademia.jegyeld.dao.SqlBuilder;

public class UpdateTicketSqlBuilder implements SqlBuilder {

    @Override
    public String build() {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ");
        sql.append("    ticket ");
        sql.append("SET ");
        sql.append("    user_id    = ?, ");
        sql.append("    updated_at = NOW() ");
        sql.append("WHERE ");
        sql.append("    ticket_id  = ?");
        return sql.toString();
    }

}