# DFESW9-To-Do-List

Hello and welcome to my To Do List Project. This is a backend app that was written in Java with Spring Boot. I am doing this project as it is a great way to introduce to me on how it would be like when creating api's as an actual backend developer as well as it is a requirement for my bootcamp. 

I expected this to be quite challeneging as it is my first time creating something like this. I was somewhat new on how to create entity related classes in spring boot, so I struggled a bit in that department. All my tests except for three went well: the User controller integration test for my readbyuserID, ReadAll and UpdateUser. These three were suprisingly expecting a return of null instead of a JSON array, suprising because my Task controller integration test was almost the same. I spent too much time on it and was not ale to find a solution, so i commented out the expected value and only tested whether the status returns the same. This will definetly be something I will fix in the near future.

I have many future plans for this project. I plan to add a front end, add many more custom queries such as "Find task by completed", and try changing around the User domain code so that my User controller integration test will pass properly.

# instructions.
You will require some software:
Java, an IDE such as eclipse, H2 console and postman to send data to the h2 database.

1)Clone or download a zip file of my repository.

2)Go to src/main/resources into the application.resources and check if spring.profiles.active=prod. If it is "=test" change it to prod.

3)In the same src/main/resources go to application-prod.properties and check if spring.h2.console.enabled=true, this makes it so that you can see the data in the H2 database.

4)Once the above steps are completed, run the project as a "Spring boot app". When it says, "ToDoList.ToDoListProjectApplication : Started ToDoListProjectApplication" in one of the last lines of the console, then you can open your postman.

5)If not already entered, input "http://localhost:8080" into the "Enter request url" area.

6)There are a number of request you are able to do. At the end of the url, you can add:

![image](https://user-images.githubusercontent.com/93192833/158563707-b236151e-89c3-4c42-b13d-93ebaefbb5a3.png)

This will create a user but you need to enter the required data for the body.

![image](https://user-images.githubusercontent.com/93192833/158563814-9b2de5e8-eac2-48f5-881d-82a067ded6e4.png)

This will update an existing user. You will need to add the number of the existing user where it has {id} as well as inputing values into the body that you want to cahnge of the existing user.

![image](https://user-images.githubusercontent.com/93192833/158563928-037ee298-8584-4bab-ae5e-6793816b31cc.png)

This will display all the users.





Here are some postman examples of inputting data and getting a return:


![image](https://user-images.githubusercontent.com/93192833/158555163-09b95873-9eb4-4d10-8471-950b76110b7a.png)

