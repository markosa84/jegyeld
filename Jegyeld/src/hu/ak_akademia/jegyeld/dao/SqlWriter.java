package hu.ak_akademia.jegyeld.dao;

import java.sql.PreparedStatement;

public interface SqlWriter {

    void write(PreparedStatement preparedStatement);

}