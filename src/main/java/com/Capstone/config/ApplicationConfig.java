package com.Capstone.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration

@EnableJpaRepositories(basePackages="com.Capstone.repo")

@EntityScan(basePackages="com.Capstone.entity")
public class ApplicationConfig {

}