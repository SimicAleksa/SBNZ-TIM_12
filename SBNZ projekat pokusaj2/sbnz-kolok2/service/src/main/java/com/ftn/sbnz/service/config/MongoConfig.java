package com.ftn.sbnz.service.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.ftn.sbnz.service.radar.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "sbnz";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017/sbnz");
    }
}
