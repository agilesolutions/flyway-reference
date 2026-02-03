# Reference project for Spring Boot, Flyway, Docker, Helm and Kubernetes

## Flyway and build
* gradle bootRun --args='--spring.profiles.active=postgresql'
* http://localhost:8080/customers
* http://localhost:8080/swagger-ui/index.html
* gradle copyDockerFile
* gradle generateHelmChart


## Kubectl

* kubectl logs -f -l xxx -n myspace
* kubectl rollout restart deploy mydeployment -n myspace
* kubectl scale deploy mydeploy --replicas=0 -n myspace


## helm

* helm template . --name-template=customer-service

## Run Postgres locally with Docker

```bash
docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres
``` 

## Run the application with Docker

```bash
docker build -t customer-service .
docker run -p 8080:8080 --link some-postgres:postgres -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/postgres -e
    SPRING_DATASOURCE_USERNAME=postgres -e SPRING_DATASOURCE_PASSWORD=mysecretpassword customer-service
```

## Docker compose Postgres and Application

```bash
docker compose up -d

docker exec -it local-postgres psql -U myuser -d mydb


```