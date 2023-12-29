package com.mail.sender.answering.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.mail.sender.answering.repository")
@EnableTransactionManagement
@EntityScan(basePackages = "com.mail.sender.answering.domain")
public class DatabaseConfiguration {

}
