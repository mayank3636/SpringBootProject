# SpringBootProject Content Management System 
Spring Boot Project is made on 
https://skillspeed.wistia.com/medias/djiqhyin0a



To run the project kindly make sure you change application.properties files 
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=welcome123
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=false
spring.jpa.hibernate.ddl-auto=create
management.security.enabled=false

# To run the project kindly import to IDE and change the following properties in application.properties
spring.datasource.username=MYSQL PASSWORD
spring.datasource.password=MYSQL USERNAME

# after changing properties file go to MYSQL and Run the query
create database mydb;
