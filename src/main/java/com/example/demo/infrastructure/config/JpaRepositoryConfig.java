package com.example.demo.infrastructure.config;


import com.example.demo.common.base.BaseJpaRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(repositoryBaseClass = BaseJpaRepositoryImpl.class,
        basePackages = "com.example.demo.infrastructure.persistence.repository")
@Configuration
public class JpaRepositoryConfig {
}
