package eu.jpereira.ex.http.api;

import eu.jpereira.ex.http.query.QueryCommand;
import eu.jpereira.ex.http.query.QueryResults;

/**
 * Created by jpereira on 19/05/2016.
 */
public interface APIVersion {

    QueryResults execute(QueryCommand queryCommand);
}
