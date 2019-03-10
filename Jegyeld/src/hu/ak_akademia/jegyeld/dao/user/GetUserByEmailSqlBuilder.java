package hu.ak_akademia.jegyeld.dao.user;

import hu.ak_akademia.jegyeld.dao.SqlBuilder;
import hu.ak_akademia.jegyeld.dto.Status;

public class GetUserByEmailSqlBuilder implements SqlBuilder {

    @Override
    public String build() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("    user_id, ");
        sql.append("    first_name, ");
        sql.append("    last_name, ");
        sql.append("    address, ");
        sql.append("    email, ");
        sql.append("    phone, ");
        sql.append("    password, ");
        sql.append("    date_of_birth, ");
        sql.append("    created_at, ");
        sql.append("    updated_at, ");
        sql.append("    status ");
        sql.append("FROM ");
        sql.append("    users ");
        sql.append("WHERE ");
        sql.append("    email = ? ");
        sql.append("    AND status = '")
                .append(Status.ACTIVE.getCode())
                .append("' ");
        return sql.toString();
    }

}
