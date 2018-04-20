package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class ProductDao {
    private final JdbcContext jdbcContext = new JdbcContext();

    public ProductDao(DataSource dataSource) {
        this.jdbcContext.dataSource = dataSource;
    }

    public Product get(Long id) throws SQLException {
        StatementStrategy statementStrategy = new GetStatementStrategy(id);
        return jdbcContext.jdbcContextForGet(statementStrategy);
    }

    public long insert(Product product) throws SQLException {
        StatementStrategy statementStrategy = new InsertStatementStrategy(product);
        return jdbcContext.jdbcContextForInsert(statementStrategy);
    }


    public void update(Product product) throws SQLException {
        StatementStrategy statementStrategy = new UpdateStatementStrategy(product);
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

    public void delete(long id) throws SQLException {
        StatementStrategy statementStrategy = new DeleteStatementStrategy(id);
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

}
