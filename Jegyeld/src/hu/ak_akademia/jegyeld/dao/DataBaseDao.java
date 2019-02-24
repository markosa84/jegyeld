package hu.ak_akademia.jegyeld.dao;

import java.sql.Connection;
import java.util.List;

public interface DataBaseDao<E> {

    Connection getConnection();

    void create(SqlBuilder sqlBuilder, SqlWriter sqlWriter);

    List<E> read(SqlBuilder sqlBuilder, SqlWriter sqlWriter, SqlReader<E> sqlReader);

    void update(E from, E to);

    void delete(SqlBuilder sqlBuilder, SqlWriter sqlWriter);

}