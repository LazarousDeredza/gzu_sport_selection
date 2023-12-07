
package com.gzu.sportsselection.config.leaseManagement;

import com.gzu.sportsselection.repository.leaseManagement.LeaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeaseConfig {
    public LeaseConfig() {
    }

    @Bean
    CommandLineRunner commandLineRunner(LeaseRepository repository) {
        return (args) -> {
        };
    }
}