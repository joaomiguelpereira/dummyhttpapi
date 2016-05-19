package eu.jpereira.ex.http.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Dummy component to decide with api implementation to use
 */

@Component
public class APIVersionBeanRepository {


    @Autowired
    private APIVersion dummyApiVersion;

    public Optional<APIVersion> getVersion(String version) {
        //FOR now return allways the only implementation

        return Optional.of(dummyApiVersion);
    }
}
