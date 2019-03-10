package hu.ak_akademia.jegyeld.dao.ticket;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.jegyeld.dao.SqlWriter;
import hu.ak_akademia.jegyeld.dto.Ticket;

public class CreateTicketSqlWriter implements SqlWriter {

	private final Ticket ticket;

	public CreateTicketSqlWriter(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setInt(i++, ticket.getPrice());
		preparedStatement.setInt(i++, ticket.getSeatNumber());
		preparedStatement.setInt(i++, ticket.getEventId());
		preparedStatement.setInt(i++, ticket.getUserId());
	}

}
