# dummyhttpapi
Bootstrap project for rest apis.

Using SpringBoot 1.3.0, this is the simplest REST api using Spring and Mongo.

To create a war file

mvn clean install

It used mongo, so expect to have mongo running in your machine or somewhere. The db can be configured per profile (dev or prod).

See files application-dev.yml and application-prod.yml for examples.

The sample aplication can be deployed on AWS with the prod profile activated. 

Ony accepts posts on one end point. The response will allways be the same

example:

curl -H "Content-Type: application/json" -X POST -d '{"api": "imdb", "query": "Indiana Jones"}' http://dummyapi-env.eu-west-1.elasticbeanstalk.com/api/dummy/v.10/query

Will return:

"data":[{"id":"573dac55e4b032220961de72","title":"Indiana Jones and the Last Crusade","year":1989,"director":"Steven Spielberg"},{"id":"573dac55e4b032220961de73","title":"Indiana Jones and the Temple of Doom","year":1984,"director":"Steven Spielberg"},{"id":"573dac55e4b032220961de74","title":"Indiana Jones and the Kingdom of the Crystal Skull","year":2008,"director":"Steven Spielberg"},{"id":"573dac55e4b032220961de75","title":"Indiana Jones 5","year":2015,"director":"Steven Spielberg"}]}




