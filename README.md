# Central UUID Service

## Run with Docker

To build and run with docker-compose:

mvn clean install && docker-compose build && docker-compose up -d
 
Each time you make a change, run that again and it will rebuild and redeploy the parts you changed. 

If you didn't make a DB schema change then the DB wont restart so the data will stick around. 


To see all the logs:

docker-compose logs -f


To shut it down:

docker-compose down


The following bits assume you are running on a local docker engine that resolves by localhost.
It is highly recommended that you instead use a docker-machine and find its IP instead, but
that makes for more difficult README documentation.


To access the Swagger documentation:

http://localhost:8080/uuid-rest-service/uuid/swagger.json (this shows minified in the browser)
http://localhost:8080/uuid-rest-service/uuid/swagger.yaml (this gets downloaded)


To get a random UUID:

http://localhost:8080/uuid-rest-service/uuid/random

