package hu.ak_akademia.jegyeld.dao.ticket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.jegyeld.dao.SqlReader;
import hu.ak_akademia.jegyeld.dao.SqlUtil;
import hu.ak_akademia.jegyeld.dto.Status;
import hu.ak_akademia.jegyeld.dto.Ticket;
import hu.ak_akademia.jegyeld.dto.User;

public class TicketSqlReader implements SqlReader<Ticket> {

	@Override
	public List<Ticket> read(ResultSet resultSet) throws SQLException {
		List<Ticket> tickets = new ArrayList<>();
		while (resultSet.next()) {
			Integer id = SqlUtil.getInteger(resultSet, "ticket_id");
			Integer price = SqlUtil.getInteger(resultSet, "price");
			Integer seatNumber = SqlUtil.getInteger(resultSet, "seat_number");
			Integer eventId = SqlUtil.getInteger(resultSet, "event_id");
			Integer userId = SqlUtil.getInteger(resultSet, "user_id");
			LocalDateTime created = SqlUtil.toLocalDateTime(resultSet.getTimestamp("created_at"));
			LocalDateTime updated = SqlUtil.toLocalDateTime(resultSet.getTimestamp("updated_at"));
			Status status = Status.getByCode(resultSet.getString("status"));

			Ticket ticket = new Ticket.Builder().id(id)
					.price(price)
					.seatNumber(seatNumber)
					.eventId(eventId)
					.userId(userId)
					.created(created)
					.updated(updated)
					.status(status)
					.build();
			tickets.add(ticket);
		}
		return tickets;
	}

}
