/**
 * 
 */
package com.hackfse.fdbck.mgmt.systm;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 689305
 *
 */
@Configuration
@EnableJpaRepositories(basePackages={"com.hackfse.fdbck.mgmt.systm.dao"})
@EntityScan(basePackages={"com.hackfse.fdbck.mgmt.systm.model"})
@EnableTransactionManagement
@EnableJpaAuditing
public class RepositoryConfig {
	@Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
 
        return dataSource;
    }
}
