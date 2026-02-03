package com.agilesolutions.reference.flyway;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayRepairConfig {

    //@Bean
    public FlywayMigrationStrategy flywayRepair () {

        return flyway -> {
            flyway.repair();
            flyway.migrate();
        };

    }


}
