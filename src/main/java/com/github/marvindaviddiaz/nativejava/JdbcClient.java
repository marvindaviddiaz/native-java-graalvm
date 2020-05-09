package com.github.marvindaviddiaz.nativejava;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcClient {

    private static final Logger logger = Logger.getLogger(JdbcClient.class.getName());

    public void test() {
        logger.info("Jdbc calls");

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
                new DriverManagerDataSource( "jdbc:mariadb://localhost:3306", "root", "root"));

        jdbcTemplate.queryForObject("select now()", new HashMap<>(),
                (rs, rowNum) -> {
                    logger.log(Level.INFO, "Current DB Date: {0}", rs.getDate(1));
                    return null;
                });

//            ALSO:
//            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/fel", "root", "root");
//            System.out.print("New Connection: ");
//            System.out.print(" AutoCommit: " + connection.getAutoCommit());
//            System.out.print(" ReadOnly: " + connection.isReadOnly());
//            int ti = connection.getTransactionIsolation();
//            System.out.println(" Isolation Level: " + (ti == 0 ? "NONE" : ti == 1 ? "READ_UNCOMMITTED" : ti == 2 ? "READ_COMMITTED" : ti == 4 ? "REPEATABLE_READ" : ti == 8 ? "SERIALIZABLE" : ti));

    }


}
