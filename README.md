# Blog App REST API with Spring Boot

This is a blog application with Spring Boot.

#### Technologies and tools that I used.

* **Spring Boot**
* **Spring Security** - **JWT**
* **Spring Data JPA** - **Hibernate**
* **Tomcat**
* **MySQL Database**
* **Lombok**
* **Docker**
* **AWS Cloud**
* **Swagger** API documentation
* **Postman** for testing REST API
* **Maven** as Build Tool

### Project Structure

![image](https://github.com/cagrisayir/blogapp/assets/44059539/93bc4263-4193-4e3c-a0ae-f432709e3681)

# Roadmap 🚏

### ✅ Create Project and set up Structure

![img.png](readme_images/img.png)

### ✅ Set up MySQL Database

* Created `myblog` database
* Configured `application.properties`
  ![img_1.png](readme_images/img_1.png)

### ✅ Create JPA Entity - Post Entity

* Used **Lombok**

### ✅ Create JPA Repository - Post Repository

* ResourceNotFoundException Custom Exception created.

### ✅ Create DTO Class - PostDto

### ✅ CRUD Operations for Post

* Create Post implemented.
    * PostController Created.
        * Create Post method implemented.
    * PostService Created.
    * PostServiceImpl implemented.
* Get All posts implemented.
* Get by ID, Delete and Update implemented.

### ✅ Pagination and Sorting

* Pagination implemented
    * new response type
    * ![img.png](readme_images/img.png)
* Sorting implemented.
    * Ordering ASC and DESC
* Get All url: `{{URL}}/api/posts?pageNo=0&pageSize=5&sortBy=title`

### CRUD REST for Comments

### Convert custom mapper to ModelMapper

### Custom Exception Handling

### Validation

### Spring Security

### Login and Register

### JWT