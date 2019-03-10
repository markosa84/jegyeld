package hu.ak_akademia.jegyeld.dao.ticket;

import hu.ak_akademia.jegyeld.dao.SqlBuilder;

public class CreateTicketSqlBuilder implements SqlBuilder {

    @Override
    public String build() {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ticket ( ");
        sql.append("    ticket_id, ");
        sql.append("    price, ");
        sql.append("    seat_number, ");
        sql.append("    event_id, ");
        sql.append("    user_id ");
        sql.append(") VALUES ( ");
        sql.append("    nextval('ticket_seq'), ");
        sql.append("    ?, ");
        sql.append("    ?, ");
        sql.append("    ?, ");
        sql.append("    ? ");
        sql.append(") ");
        return sql.toString();
    }

}