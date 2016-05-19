package eu.jpereira.ex.http.api;

import eu.jpereira.ex.http.model.Movie;
import eu.jpereira.ex.http.model.MoviesRepository;
import eu.jpereira.ex.http.query.QueryCommand;
import eu.jpereira.ex.http.query.QueryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jpereira on 19/05/2016.
 */
@Component
public class DummyAPIVersion implements APIVersion {

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public QueryResults execute(QueryCommand queryCommand) {
        //For now return always the same response
        List<Movie> movies = moviesRepository.findAll();
        return new QueryResults(movies);

    }
}
