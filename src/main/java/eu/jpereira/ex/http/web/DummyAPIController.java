package eu.jpereira.ex.http.web;

import eu.jpereira.ex.http.api.APIVersion;
import eu.jpereira.ex.http.api.APIVersionBeanRepository;
import eu.jpereira.ex.http.query.QueryCommand;
import eu.jpereira.ex.http.query.QueryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Just a Dummy REST Controller
 */
@RestController
@RequestMapping("/api/dummy/{version}/query")
public class DummyAPIController {


    @Autowired
    private APIVersionBeanRepository apiVersionRepository;

    @RequestMapping(method = RequestMethod.POST)
    public QueryResults query(@PathVariable("version") String version, @RequestBody QueryCommand queryCommand) {


        Optional<APIVersion> apiVersion = apiVersionRepository.getVersion(version);

        if (apiVersion.isPresent()) {

            return apiVersion.get().execute(queryCommand);
        }

        throw new IllegalArgumentException("Could not find a version for the api");


    }
}
