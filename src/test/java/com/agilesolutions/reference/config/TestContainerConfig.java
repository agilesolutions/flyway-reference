package com.agilesolutions.reference.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class TestContainerConfig {


    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSource() {

        DataSourceProperties dataSourceProperties = dataSourceProperties();
        log.info("*********** DataSource Properties ***********");
        log.info(dataSourceProperties.getUrl());
        log.info(dataSourceProperties.getUsername());
        log.info(dataSourceProperties.getPassword());
        log.info(dataSourceProperties.getDriverClassName());
        log.info("*********************************************");

        return dataSourceProperties
                .initializeDataSourceBuilder()
                .driverClassName("org.postgresql.Driver")
                .build();
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
