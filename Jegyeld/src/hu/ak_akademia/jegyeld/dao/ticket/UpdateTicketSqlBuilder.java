package hu.ak_akademia.jegyeld.dao.ticket;

import hu.ak_akademia.jegyeld.dao.SqlBuilder;

public class UpdateTicketSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ticket ");
		sql.append("SET price = '");
		sql.append("?");
		sql.append("', ");
		sql.append("? ");
		sql.append("WHERE product_id = ");
		sql.append("?");
		return sql.toString();
	}

}
