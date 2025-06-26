# klik-indomaret-android-automation-framework
A mobile native app & webview automation ANDROID framework with Appium


#### Automation Setup guidelines:
 - Make sure that Maven, Java (openjdk-20), appium server are installed in the system 
 - Check out GitHub repo into any IDE (preferred intellij)
 - Check that lombok plugin is installed 
 - This repo does not have android .apk files, you should use your own executable file.
 - basic commands to run tests - open terminal and go to project directory and run command : mvn clean install
  - After test build, run following command in terminal for allure report generation : allure serve allure-results
  - Above command will generate allure report and launch these reports in system's default browser 
 - It runs only on Mac as I do not have windows machine so did not prepare for it (but with few changes in file paths etc. it is possible)

#### Key features of framework used  : 
-  Page Object Model 
 - Java : most convenient programming language for me
 - Maven: For build managemnt purpose, a common structure can be maintained very easily
 - Appium: Open source, most convenient native mobile app automation tool
 - Allure Reports : As it is most clean automation reports and provides lots of useful annotations as well. For better documentation, it has been chosen over other reporting tools
 - Lombok plugin : It provides very simple logging framework as compared to other logging methods
 - It automatically starts appium server and kills its instance after tests are executed
 



### Reasons for choosing the framework : Page Object Model
- According to Page Object Model, we should keep our tests and element locators separately, this will keep code clean and easy to understand and maintain.
- The Page Object approach makes test automation framework programmer friendly, more durable and comprehensive.
- Another important advantage is our Page Object Repository is Independent of Automation Tests. Keeping separate repository for page objects helps us to use this repository for different purposes with different frameworks like, we are able to integrate this repository with other tools like like TestNG/Cucumber/etc.
- Test cases become short and optimized as we are able to reuse page object methods in the POM classes.
- Any change in UI can easily be implemented, updated and maintained into the Page Objects and Classes.
- Easily Scalable approach

### Adavntages of POM framework?
- Advantages of POM are expalined above. Here are few disadvantages of POM approach
- If there is an application with hundreds or thousands of web pages than the time and the effort in the development of automation framework will be high.
- The cost increases when maintenance overhead increases which are due to the maintenance of large class as they break the OO design principle.
- The development of POM framework for multiple pages is equal to developers work thus testers should be highly knowledgeable in programming best practices.
- Page object model is not a generic model and its specific to the applications.


### Few best Coding practices are followed while writing automation script: 
- KISS (Keep it simple, stupid)
- YAGNI (You are gonna need it)
- DRY (Don't repeat yourself) : by providing reusbale functions 
- Static methods
- OOPS concepts

### Some tips on how to make make sure your code is maintainable by other team members?
- In POM framework, it is very easy to understand for everyone so any one can contribute without investing much time on understanding it
- Having proper and meaningful package names, it is very easy to find them and use them
- Use comments wherever needed
- descriptive variable, method, class names
- Use design patterns

 #### Original Author : [LinkedIn](https://www.linkedin.com/in/surendra-singh-db/)







 
