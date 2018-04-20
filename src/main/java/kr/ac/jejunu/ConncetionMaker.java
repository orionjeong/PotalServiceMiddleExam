package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConncetionMaker {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}
