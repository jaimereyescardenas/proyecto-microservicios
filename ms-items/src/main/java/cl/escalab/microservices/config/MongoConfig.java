package cl.escalab.microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


@Configuration
@EnableMongoRepositories(basePackages="cl.escalab.microservices.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {
  
	@Override
    protected String getDatabaseName() {
        return "ms-items";
    }
  
    @Bean
    @Override
    public MongoClient mongoClient() {
    	ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/ms-items");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
        return MongoClients.create(mongoClientSettings);
    }
}