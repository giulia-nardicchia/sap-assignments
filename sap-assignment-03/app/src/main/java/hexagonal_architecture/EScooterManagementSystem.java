package hexagonal_architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class EScooterManagementSystem {
    public static void main(String[] args) {
        SpringApplication.run(EScooterManagementSystem.class, args);
    }
}