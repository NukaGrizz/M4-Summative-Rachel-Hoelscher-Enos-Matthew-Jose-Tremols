## In order to run need to add the following file with your own password in place of MYSQL password

### src/main/resources/application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/game_store?useSSL=false&serverTimezone=US/Central&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=MYSQLPASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.datasource.driver-class-name: com.mysql.jdbc.Driver
```