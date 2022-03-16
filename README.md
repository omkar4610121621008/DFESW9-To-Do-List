# DFESW9-To-Do-List

Hello and welcome to my To Do List Project. This is a backend app that was written in Java with Spring Boot. I am doing this project as it is a great way to introduce to me on how it would be like when creating api's as an actual backend developer as well as it is a requirement for my bootcamp. 

I expected this to be quite challeneging as it is my first time creating something like this. I was somewhat new on how to create entity related classes in spring boot, so I struggled a bit in that department. All my tests except for three went well: the User controller integration test for my readbyuserID, ReadAll and UpdateUser. These three were suprisingly expecting a return of null instead of a JSON array, suprising because my Task controller integration test was almost the same. I spent too much time on it and was not ale to find a solution, so i commented out the expected value and only tested whether the status returns the same. This will definetly be something I will fix in the near future.

I have many future plans for this project. I plan to add a front end, add many more custom queries such as "Find task by completed", and try changing around the User domain code so that my User controller integration test will pass properly.

Here are some postman examples of inputting data and getting a return:
