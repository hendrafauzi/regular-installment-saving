# regular-installment-saving
Here we have been created regular installment saving REST API using Spring Boot and database MySQL.

Regular Installment Saving have 4 API's, such as:
    
    
    - API for get all data as array list 
      Method: GET
  
![image](https://user-images.githubusercontent.com/30804094/136701222-e00200dc-3c63-4c5e-aff1-010635d99a4d.png)


    - API for calculate (inquiry) the tenor and deposit
      Method: POST
  
![image](https://user-images.githubusercontent.com/30804094/136701267-42c93059-1207-4c32-adcc-66e019190a9f.png)


    - API for create (insert) new installment saving
      Method: POST
  
![image](https://user-images.githubusercontent.com/30804094/136701330-e392ad34-052d-47ae-a1b3-99dc14640aa2.png)


    - API for get the data by id
      Method: GET
  
![image](https://user-images.githubusercontent.com/30804094/136701390-24d5b0dc-8aa0-43f9-9723-da82d531d49d.png)



HOW TO RUN THIS PROJECT?
1. We need to create the database and table from the installment.sql file on the project.
2. mvn clean install 
3. java -jar target/regular-installment-saving-0.0.1-SNAPSHOT.jar
