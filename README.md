# DFESW9-To-Do-List

Hello and welcome to my To Do List Project. This is a backend api that was written in Java with Spring Boot. I am doing this project as it is a great way to introduce to me on how it would be like when creating api's as an actual backend developer as well as it is a requirement for my bootcamp. 

I expected this to be quite challenging as it is my first time creating something like this. I was somewhat new on how to create entity related classes in spring boot, so I struggled a bit in that department. All my tests except for three went well: the User controller integration test for my readbyuserID, ReadAll and UpdateUser. These three were suprisingly expecting a return of null instead of a JSON array, suprising because my Task controller integration test was almost the same but were working properly. I spent too much time on it and was not able to find a solution, so I commented out the expected value and only tested whether the status returns the same. This will definetly be something I will fix in the near future.

I have many future plans for this project. I plan to add a front end, add many more custom queries such as "Find task by completed", and try changing around the User domain code so that my User controller integration test will pass properly.

# Required Software
You will software such as:
Java

IDE such as eclipse

H2 console

postman to send data to the h2 database.

# Instructions.

1)Clone or download a zip file of my repository.

2)Go to src/main/resources into the application.resources and check if "spring.profiles.active=prod". If it is "test" change it to "prod".

3)In the same src/main/resources go to application-prod.properties and check if "spring.h2.console.enabled=true", this makes it so that you can see the data in the H2 database.

4)Once the above steps are completed, run the project as a "Spring boot app". When it says, "ToDoList.ToDoListProjectApplication : Started ToDoListProjectApplication" in one of the last lines of the console, then you can open your postman.

5)If not already entered, input "http://localhost:8080" into the "Enter request url" area.

6)There are a number of request you are able to do. At the end of the url, you can add:

![image](https://user-images.githubusercontent.com/93192833/158563707-b236151e-89c3-4c42-b13d-93ebaefbb5a3.png)

This will create a user but you need to enter the required data for the body.

![image](https://user-images.githubusercontent.com/93192833/158563814-9b2de5e8-eac2-48f5-881d-82a067ded6e4.png)

This will update an existing user. You will need to add the number of the existing user where it has {id} as well as inputing values into the body that you want to change of the existing user.

![image](https://user-images.githubusercontent.com/93192833/158563928-037ee298-8584-4bab-ae5e-6793816b31cc.png)

This will display all the users as well as the tasks assigned to them.

![image](https://user-images.githubusercontent.com/93192833/158564478-1ce98edc-e632-4fbc-866e-8bb0a400bf15.png)

This will display a specific user by inputting the id of the user.

![image](https://user-images.githubusercontent.com/93192833/158564594-32cc6778-2e26-4706-9084-c096e2e25004.png)

This will delete the specific user from the database and return true or 1 to confirm it by inputting the user id. When deleting a user with a task in it, the task will also be deleted.

![image](https://user-images.githubusercontent.com/93192833/158564780-c4392a7e-0d27-4ae0-b317-284874654874.png)

This will create a task but you need to enter the required data for the body.

![image](https://user-images.githubusercontent.com/93192833/158564876-2717be9b-30d1-418d-aa51-60590814b11c.png)

This will update an existing task. You will need to add the number of the existing task where it has {id} as well as inputing values into the body that you want to change of the existing task.

![image](https://user-images.githubusercontent.com/93192833/158565023-2fedc0be-90e1-4e8b-9fde-fde1096673fa.png)

This will assign a task to a user. you will need to input the id's of both the task and user and it will be assigned. When you get the user by id, you will see the task nested in a list inside the user body.

![image](https://user-images.githubusercontent.com/93192833/158565455-51847c93-5167-4f9d-a5c3-d58306bb58ec.png)

This will display all the tasks.

![image](https://user-images.githubusercontent.com/93192833/158565554-2eaa704b-cdac-4e8f-aac6-e154fc1c9934.png)

This will display a specific task by inputting the id of the task.

![image](https://user-images.githubusercontent.com/93192833/158565693-e232643e-84e5-4600-8ee6-1b023c56ff6f.png)

This will delete the specific task from the database and return true or 1 to confirm it by inputting the task id. When deleting a task that is assigned to a user, the user will NOT be deleted.


7)Open the h2 console or type in your browser: http://localhost:8080/h2 to open your database.

8)The details of the database url, username and password should automatically be present in the console. If not, grab the login the details from the application-prod.properties file in your src/main/resources.

9)Once in the database, type in "Select * from task;" and "select * from task_user;" and press run. You will then see your data.

**You can also run the .jar file located in the file of the project and then move onto the postman steps straight way(I recently found this out and it is amazing)**

# Examples

Here are some postman examples of inputting data and getting a return:

Creating a user with a nested task:

![image](https://user-images.githubusercontent.com/93192833/158555163-09b95873-9eb4-4d10-8471-950b76110b7a.png)

Updating the user:

![image](https://user-images.githubusercontent.com/93192833/158566371-cb315b26-b482-455e-9ea4-bf5951b5e07a.png)

Data shown in the database:

![image](https://user-images.githubusercontent.com/93192833/158566448-075122ab-a99f-4d84-9410-b1541a62565e.png)

# Testing

To run the tests, go to application.resources located in the src/main/resources and make sure it is "spring.profiles.active=test". Once done, Run the project file as JUnit test and you will see the tests run. I did unit tests for all my classes and integration tests for my TaskUser and Task controller classes. However I must remind you that three of my tests in my User integration test were expecting null, so I will need to work on that. I managed to cover 94.3% of my main and I will create more tests to increase that. 

![image](https://user-images.githubusercontent.com/93192833/158567612-2853db5b-8d0e-4886-98c7-714c6d9e8282.png)
![image](https://user-images.githubusercontent.com/93192833/158567636-621db466-a4d5-412f-be43-e09c518a7fd6.png)

# Jira Link

https://omkarwatkinson.atlassian.net/jira/software/projects/TOD/boards/2/roadmap

# Conclusion

Many thanks to the DFE tutors such as Piers Barber and Chris Yiangou as well as many others that have helped throughout this bootcamp. Also Thanks to my fellow peers, it was quite a journey.

# Author

Omkar Watkinson



