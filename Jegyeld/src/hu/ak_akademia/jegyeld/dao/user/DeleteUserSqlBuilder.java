package hu.ak_akademia.jegyeld.dao.user;

import hu.ak_akademia.jegyeld.dao.SqlBuilder;
import hu.ak_akademia.jegyeld.dto.Status;

public class DeleteUserSqlBuilder implements SqlBuilder {

    @Override
    public String build() {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE users ");
        sql.append("SET ");
        sql.append("    status = '")
                .append(Status.DELETED.getCode())
                .append("', ");
        sql.append("updated_at = now() ");
        sql.append("WHERE ");
        sql.append("user_id = ? ");
        return sql.toString();
    }

}
