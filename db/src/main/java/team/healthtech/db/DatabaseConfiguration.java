package team.healthtech.db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = {
    "team.healthtech.db.entity",
    "team.healthtech.db.converter",
    "team.healthtech.db.projection"
})
@EnableJpaRepositories(basePackages = "team.healthtech.db.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {
}
