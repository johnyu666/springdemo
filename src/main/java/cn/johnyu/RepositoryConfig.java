package cn.johnyu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db_h2.properties")
@Profile("development")
public class RepositoryConfig {
    @Value("${url}") String url;
    @Value("${driverClassName}") String driverClassName;
    @Value("${username}") String username;
    @Value("${password}") String password;
    @Bean
    public DataSource createDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate createTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }
}
