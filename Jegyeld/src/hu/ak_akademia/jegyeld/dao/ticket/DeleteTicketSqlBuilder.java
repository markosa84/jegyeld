package hu.ak_akademia.jegyeld.dao.ticket;

import hu.ak_akademia.jegyeld.dao.SqlBuilder;
import hu.ak_akademia.jegyeld.dto.Status;

public class DeleteTicketSqlBuilder implements SqlBuilder {

    @Override
    public String build() {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ");
        sql.append("    ticket ");
        sql.append("SET ");
        sql.append("    status = '")
                .append(Status.DELETED.getCode())
                .append("', ");
        sql.append("    updated_at = NOW() ");
        sql.append("WHERE ");
        sql.append("    ticket_id = ? ");
        return sql.toString();
    }

}