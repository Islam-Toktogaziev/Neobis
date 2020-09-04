#For dockerfile
1. Create network:
`docker network create my-network`

2. Build MySQL container:
```
cd .\mysql_folder\
docker image build -t custom-mysql-image .
```

3. Run container:
`docker container run -d --net my-network -v mysql-storage:/var/lib/mysql --name custommysql custom-mysql-image`

4. Create Database:
```
docker container exec -it custommysql bash
```
In bash:
```
mysql -uroot -p < createdb.sql 
```

Then `exit`

5. Create JAR file:
```
cd ..
mvn clean package
```

6. Build application container:
`docker image build -t avtoshop-spring-boot .`

7. Run container:
`docker container run -p 8081:8081 --net feedback-network --name feedbackservice feedbackserviceimage`

8. Ready


#For docker-compose

1. Run docker-compose
`docker-compose up --build`

2. Ready

