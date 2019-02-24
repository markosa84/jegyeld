package hu.ak_akademia.jegyeld.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SqlWriter {

    void write(PreparedStatement preparedStatement) throws SQLException;

}