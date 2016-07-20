package com.example.DB;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by karol on 20.07.16.
 */
@EnableTransactionManagement
@Configuration
@ComponentScan("com.example")
public class JPAConfig {
}
