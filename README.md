# async-mvc
###maven run 
> 
    ./mvnw package && java -jar  ./target/async-mvc-0.0.1-SNAPSHOT.jar
###docker build
> 
    ./mvnw install dockerfile:build
 
###prod run
> 
    docker run  --name async-mvc -e OPTIONS="-Dspring.profiles.active=prod"  --link mysql-crawler:mysql --link redis:redis -p 8080:8080 -d cifnews/async-mvc

