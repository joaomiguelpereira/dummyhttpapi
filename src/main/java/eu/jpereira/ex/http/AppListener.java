package eu.jpereira.ex.http;

import eu.jpereira.ex.http.model.Movie;
import eu.jpereira.ex.http.model.MoviesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpereira on 19/05/2016.
 */

@Component
public class AppListener  {


    private static List<Movie> moviesDummy = new ArrayList<Movie>(4);

    static {
        moviesDummy.add(new Movie("Indiana Jones and the Last Crusade", 1989, "Steven Spielberg"));
        moviesDummy.add(new Movie("Indiana Jones and the Temple of Doom", 1984, "Steven Spielberg"));
        moviesDummy.add(new Movie("Indiana Jones and the Kingdom of the Crystal Skull", 2008, "Steven Spielberg"));
        moviesDummy.add(new Movie("Indiana Jones 5", 2015, "Steven Spielberg"));
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(AppListener.class);


    @Autowired
    private MoviesRepository moviesRepository;

    @EventListener({ContextRefreshedEvent.class})
    void contextRefreshedEvent() {



        long count = moviesRepository.count();
        if (count < 4) {
            popuplateDBWithDummyData();
        }

    }


    //Quick dirty way to put data on the db for testing
    private void popuplateDBWithDummyData() {

        LOGGER.info("Populating dummy DB...");
        moviesRepository.deleteAll();
        moviesRepository.save(moviesDummy);

    }
}
