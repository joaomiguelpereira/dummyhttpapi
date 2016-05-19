package eu.jpereira.ex.http.query;

/**
 * Simple query command
 */
public class QueryCommand {

    private String api;
    private String query;


    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
