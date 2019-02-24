package hu.ak_akademia.jegyeld.dao;

import java.sql.ResultSet;
import java.util.List;

public interface SqlReader<E> {

    List<E> read(ResultSet resultSet);

}