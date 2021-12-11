# 12-spring-boot-jpa-rest  
Spring Boot Learning Project.  
CRM app: expose Rest endpoints for: add Customer, get all customer, get customer, update customer, delete customer.  
Use Hibernate or JPA or Spring Data JPA and Rest Controller.  
Use MySQL database with one table: customer.  


Spring Boot Dependency: Spring Web ; Data JPA; DevTools; MySQL Driver.  


| HTTP Method | CRUD   | Action	Edpoint |
| :---------- |:------:| :--------------|
| POST        | CREATE | /api/customers |
| GET         | READ   | <ul><li>/api/customers</li><li> /api/customers/{customerId}</li>|
| PUT         | UPDATE | /api/customers |  
| DELETE      | DELETE | /api/customers/{customerId} |    



Set database connections in application.properties. No need for connection pools .
Spring Boot automatically create beans: DataSource, EntityManager.
EntitiManager is similar to Hibernate SessionFactory.

To run the App consider that there are three JPA implementation(Hibernate(JPA implementation)/  JPA /  Spring Data JPA) and two Rest Controller:
  - to use Hibernate :  
      - in Service use: @qualifier hibernate;    
      - in RestController use: @qualifier employee service hibernateAndJpa.
  -	tu use JPA  
      - in Service use: @qualifier JPA;  
      - in RestController use: @qualifier employee service hibernateAndJpa.
  -	to use Spring Data JPA :   
      - in RestController use: @qualifier employee service SpringDataJPA.  
      
      
      
Steps to create the app:   
  - generate project: start.spring.io;    
  - edit application.properties;   
  - create entity, No-arg constructor required for entity by Hibernate;  
  - create DAO;   
  - Create Service;   
  - Create RestController

Spring Data JPA : need entity type and id and  creates all data CRUD methods


   
   
   
[BACK TO START PAGE](https://github.com/FlorescuAndrei/Start.git) 
    
