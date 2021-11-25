# Spring Boot Exception Handling with Aspect


### 📖 Information

<ul style="list-style-type:disc">
  <li> The sample project is based on handling with the error while CRUD process tries to be implemented.</li>
  <li> It throws an error covering its details information when any endpoint cannot be performed.</li>
  <li> It also shows an information when any service triggered by its own endpoint is called according to AOP</li>
</ul>


### 🔨 Run the App

There are 2 ways to run the app.

### Docker Compose

1. : Download your project from this link `https://github.com/Rapter1990/SpringBootExceptionHandlingAspect`
2. : Go to the project's home directory though this command : `cd SpringBootExceptionHandlingAspect`
3. : Create docker image though this command `docker build -t app . `
4. : Show all docker images in docker though this command `docker image ls`
5. : Show the docker images running in docker though this command `docker image ls`
6. : Run the project in docker though this command `docker run -p 9999:8082 app`

### Maven

1. Download your project from this link `https://github.com/Rapter1990/SpringBootExceptionHandlingAspect`
2. Go to the project's home directory :  `cd SpringBootExceptionHandlingAspect`
3. Create a jar file though this command `mvn clean install`
4. Run the project though this command `mvn spring-boot:run`

Use 8082 port to run the app in Maven part while docker runs the project in port number 9999.

### Screenshots

<details>
<summary>Click here to show the screenshots of project</summary>
    <p> Figure 1 </p>
    <img src ="spring_boot_exception_handling_screenshots/1_user_create.PNG">
    <p> Figure 2 </p>
    <img src ="spring_boot_exception_handling_screenshots/1_user_delete.PNG">
    <p> Figure 3 </p>
    <img src ="spring_boot_exception_handling_screenshots/1_user_getAll.PNG">
    <p> Figure 4 </p>
    <img src ="spring_boot_exception_handling_screenshots/1_user_getUserById.PNG">
    <p> Figure 5 </p>
    <img src ="spring_boot_exception_handling_screenshots/1_user_update.PNG">
    <p> Figure 6 </p>
    <img src ="spring_boot_exception_handling_screenshots/2_category_create.PNG">
    <p> Figure 7 </p>
    <img src ="spring_boot_exception_handling_screenshots/2_category_delete.PNG">
    <p> Figure 8 </p>
    <img src ="spring_boot_exception_handling_screenshots/2_category_getAll.PNG">
    <p> Figure 9 </p>
    <img src ="spring_boot_exception_handling_screenshots/2_category_getCategoryById.PNG">
    <p> Figure 10 </p>
    <img src ="spring_boot_exception_handling_screenshots/2_category_update.PNG">
    <p> Figure 11 </p>
    <img src ="spring_boot_exception_handling_screenshots/3_product_create.PNG">
    <p> Figure 12 </p>
    <img src ="spring_boot_exception_handling_screenshots/3_product_delete.PNG">
    <p> Figure 13 </p>
    <img src ="spring_boot_exception_handling_screenshots/3_product_getProductById.PNG">
    <p> Figure 14 </p>
    <img src ="spring_boot_exception_handling_screenshots/3_product_update.PNG">
    <p> Figure 15 </p>
    <img src ="spring_boot_exception_handling_screenshots/4_payment_create.PNG">
    <p> Figure 16 </p>
    <img src ="spring_boot_exception_handling_screenshots/4_payment_delete.PNG">
    <p> Figure 17 </p>
    <img src ="spring_boot_exception_handling_screenshots/4_payment_getAll.PNG">
    <p> Figure 18 </p>
    <img src ="spring_boot_exception_handling_screenshots/4_payment_getPaymentById.PNG">
    <p> Figure 19 </p>
    <img src ="spring_boot_exception_handling_screenshots/4_payment_update.PNG">
    <p> Figure 20 </p>
    <img src ="spring_boot_exception_handling_screenshots/5_order_create.PNG">
    <p> Figure 21 </p>
    <img src ="spring_boot_exception_handling_screenshots/5_order_delete.PNG">
    <p> Figure 22 </p>
    <img src ="spring_boot_exception_handling_screenshots/5_order_getAll.PNG">
    <p> Figure 23 </p>
    <img src ="spring_boot_exception_handling_screenshots/5_order_getOrderById.PNG">
    <p> Figure 24 </p>
    <img src ="spring_boot_exception_handling_screenshots/5_order_update.PNG">
    <p> Figure 25 </p>
    <img src ="spring_boot_exception_handling_screenshots/6_orderitem_create.PNG">
    <p> Figure 26 </p>
    <img src ="spring_boot_exception_handling_screenshots/6_orderitem_delete.PNG">
    <p> Figure 27 </p>
    <img src ="spring_boot_exception_handling_screenshots/6_orderitem_getAll.PNG">
    <p> Figure 28 </p>
    <img src ="spring_boot_exception_handling_screenshots/6_orderitem_getOrderItemById.PNG">
    <p> Figure 29 </p>
    <img src ="spring_boot_exception_handling_screenshots/6_orderitem_update.PNG">
    <p> Figure 30 </p>
    <img src ="spring_boot_exception_handling_screenshots/7_error_message.PNG">
</details>
