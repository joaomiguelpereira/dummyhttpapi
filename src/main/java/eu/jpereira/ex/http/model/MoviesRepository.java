package eu.jpereira.ex.http.model;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jpereira on 19/05/2016.
 */
public interface MoviesRepository extends MongoRepository<Movie, String>{
}
