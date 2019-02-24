package hu.ak_akademia.jegyeld.dao.user;

import hu.ak_akademia.jegyeld.dao.SqlBuilder;

public class CreateUserSqlBuilder implements SqlBuilder {

    @Override
    public String build() {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO users ( ");
        sql.append("    user_id, ");
        sql.append("    first_name, ");
        sql.append("    last_name, ");
        sql.append("    address, ");
        sql.append("    phone, ");
        sql.append("    email, ");
        sql.append("    password, ");
        sql.append("    date_of_birth ");
        sql.append(") VALUES ( ");
        sql.append("    nextval('users_seq'), ");
        sql.append("    ?, ");
        sql.append("    ?, ");
        sql.append("    ?, ");
        sql.append("    ?, ");
        sql.append("    ?, ");
        sql.append("    ?, ");
        sql.append("    ? ");
        sql.append(") ");
        return sql.toString();
    }
}
