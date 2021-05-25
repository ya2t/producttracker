# producttracker
This is a sample applicaion created using spring boot with in memory db for now. 
## Running product tracker using Maven
 - Open a terminal and navigate to `producttracker` folder
 - Run the following `Maven` command to start the application
   ```
    ./mvnw clean spring-boot:run
   ```
  - Port set up for 8001

  | Endpoint                                                          | Secured              |
  | ----------------------------------------------------------------- | ---------------------|
  | `GET /api/v1/product`                                             | get list of products |
  | `POST /api/v1/product`                                            | creeate new products | 
  | `GET /api/v1/product/{number}`                                    | get single product   |                            
  | `PUT /api/v1/product/{number}`                                    | update prduct        |
  | `DELETE /api/v1/product/{number}`                                 | remove product       |

