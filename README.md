# dummyhttpapi
Bootstrap project for rest apis.

Using SpringBoot 1.3.0, this is the simplest REST api using Spring and Mongo.

To create a war file

mvn clean install

It used mongo, so expect to have mongo running in your machine or somewhere. The db can be configured per profile (dev or prod).

See files application-dev.yml and application-prod.yml for examples.


