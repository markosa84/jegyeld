package hu.ak_akademia.jegyeld.dao.ticket;

import hu.ak_akademia.jegyeld.dao.SqlBuilder;
import hu.ak_akademia.jegyeld.dto.Status;

public class GetTicketByIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("    ticket_id, ");
		sql.append("    price, ");
		sql.append("    seat_number, ");
		sql.append("    event_id, ");
		sql.append("    user_id ");
		sql.append("FROM ");
		sql.append("    ticket ");
		sql.append("WHERE ");
		sql.append("    ticket_id = ? ");
		sql.append("    AND status = '")
				.append(Status.ACTIVE.getCode())
				.append("' ");
		return sql.toString();
	}

}
