package br.com.s2it.blog;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
public class DBConfig {

    @Bean
    @ConfigurationProperties(prefix="mysql.datasource")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate mysqlJdbcTemplate(DataSource mysqlDataSource){
        return new JdbcTemplate(mysqlDataSource);
    }

    @Bean
    @ConfigurationProperties(prefix="postgres.datasource")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate postgresJdbcTemplate(DataSource postgresDataSource){
        return new JdbcTemplate(postgresDataSource);
    }
}
