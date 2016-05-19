package eu.jpereira.ex.http.persistence;


import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableMongoRepositories(basePackages = {"eu.jpereira.**.model"})
public class MongoConfiguration extends AbstractMongoConfiguration {


    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MongoConfiguration.class);
    @Value("${database.host}")
    private String host;

    @Value("${database.name}")
    private String dbname;

    @Value("${database.port}")
    private int port;

    @Value("${database.user}")
    private String user;

    @Value("${database.password}")
    private String password;

    @Override
    protected String getDatabaseName() {
        return dbname;
    }

    @Bean
    public Mongo mongo() throws UnknownHostException {
        Optional<List<MongoCredential>> credentialList = getMongoCredentials();

        if (credentialList.isPresent()) {

            return new MongoClient(getServerAddress(), credentialList.get());
        }

        return new MongoClient(getServerAddress());
    }

    private ServerAddress getServerAddress() {

        try {
            ServerAddress serverAddress = new ServerAddress(host, port);
            return serverAddress;
        } catch (UnknownHostException e) {
            LOGGER.error("Database configuration: ", e);
            throw new RuntimeException(e);
        }
    }

    private Optional<List<MongoCredential>> getMongoCredentials() {

        if (!StringUtils.isEmpty(this.user)) {
            MongoCredential credential = MongoCredential.createCredential(user, dbname, password.toCharArray());
            List<MongoCredential> credentialList = new ArrayList(1);
            credentialList.add(credential);
            return Optional.of(credentialList);
        }
        return Optional.empty();
    }

}
