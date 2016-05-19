package eu.jpereira.ex.http.query;

import java.util.List;

/**
 * Simple Query Results
 */
public class QueryResults {

    private final List data;

    public QueryResults(List movies) {
        this.data = movies;
    }

    public List getData() {
        return data;
    }
}
