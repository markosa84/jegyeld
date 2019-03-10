package hu.ak_akademia.jegyeld.dao.ticket;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.jegyeld.dao.SqlWriter;
import hu.ak_akademia.jegyeld.dto.Ticket;

public class UpdateTicketSqlWriter implements SqlWriter {

    private final Ticket ticket;

    public UpdateTicketSqlWriter(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void write(PreparedStatement preparedStatement) throws SQLException {
        int i = 1;
        preparedStatement.setInt(i++, ticket.getUserId());
        preparedStatement.setInt(i++, ticket.getId());
    }

}