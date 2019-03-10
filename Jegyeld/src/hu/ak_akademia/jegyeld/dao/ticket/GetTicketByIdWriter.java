package hu.ak_akademia.jegyeld.dao.ticket;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.jegyeld.dao.SqlWriter;

public class GetTicketByIdWriter implements SqlWriter {

	private final int id;

	public GetTicketByIdWriter(int id) {
		this.id = id;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setInt(1, id);
	}

}
