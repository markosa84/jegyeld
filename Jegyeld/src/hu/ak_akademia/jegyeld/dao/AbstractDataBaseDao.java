package hu.ak_akademia.jegyeld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.jegyeld.dto.User;

public abstract class AbstractDataBaseDao<E> implements DataBaseDao<E> {

    @Override
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost/jegyeld", "jegyeld", "admin");
        } catch (SQLException | ClassNotFoundException e) {
            throw new JegyeldRuntimeException("Az adatbázishoz csatlakozás sikertelen volt.", e);
        }
    }

    @Override
    public void create(SqlBuilder sqlBuilder, SqlWriter sqlWriter) {
        String sql = sqlBuilder.build();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            sqlWriter.write(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new JegyeldRuntimeException("Adatbázisba új rekord felvitele sikertelen.", e);
        }
    }

    @Override
    public void update(E from, E to) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(SqlBuilder sqlBuilder, SqlWriter sqlWriter) {
        String sql = sqlBuilder.build();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            sqlWriter.write(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new JegyeldRuntimeException("A rekord törlése az adatbázisból sikertelen.", e);
        }
    }

    @Override
    public List<E> read(SqlBuilder sqlBuilder, SqlWriter sqlWriter, SqlReader<E> sqlReader) {
        String sql = sqlBuilder.build();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            sqlWriter.write(preparedStatement);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return sqlReader.read(resultSet);
            }
        } catch (SQLException e) {
            throw new JegyeldRuntimeException("Hiba az adatbázisban történő lekérdezés közben.", e);
        }
    }

}