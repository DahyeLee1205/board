package com.example.common.config

import org.springframework.context.annotation.Configuration

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    /*    @Bean
        @ConfigurationProperties("spring.datasource.hikari")
        public HikariConfig hikariConfig() {
            return new HikariConfig();
        }

        @Bean
        public DataSource dataSource(HikariConfig hikariConfig) {
            HikariDataSource dataSource = new HikariDataSource(hikariConfig);
            return dataSource;
        }*/

}