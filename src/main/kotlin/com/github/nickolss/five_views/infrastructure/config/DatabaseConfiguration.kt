package com.github.nickolss.five_views.infrastructure.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DatabaseConfiguration {
    @Value("\${spring.datasource.url}")
    private lateinit var url: String

    @Value("\${spring.datasource.username}")
    private lateinit var username: String

    @Value("\${spring.datasource.password}")
    private lateinit var password: String

    @Value("\${spring.datasource.driverClassName}")
    private lateinit var driver: String

    @Bean
    fun hikariDataSource(): DataSource {
        val hikariConfig = HikariConfig().apply {
            jdbcUrl = this@DatabaseConfiguration.url
            username = this@DatabaseConfiguration.username
            password = this@DatabaseConfiguration.password
            driverClassName = this@DatabaseConfiguration.driver
            maximumPoolSize = 10
            minimumIdle = 2
            idleTimeout = 10000
            connectionTimeout = 20000
        }

        return HikariDataSource(hikariConfig)
    }

}