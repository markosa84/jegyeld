package hu.ak_akademia.jegyeld.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SqlUtil {

    private SqlUtil() {
    }

    public static LocalDate toLocalDate(Date date) {
        return date == null ? null : date.toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(Timestamp timeStamp) {
        return timeStamp == null ? null : timeStamp.toLocalDateTime();
    }

    public static Integer getInteger(ResultSet resultSet, String columnName) throws SQLException {
        int intValue = resultSet.getInt(columnName);
        return resultSet.wasNull() ? null : intValue;
    }

    public static Date toDate(LocalDate date) {
        return Date.valueOf(date);
    }

    public static Timestamp toTimeStamp(LocalDateTime dateTime) {
        return Timestamp.valueOf(dateTime);
    }

}