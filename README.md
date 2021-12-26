# seleniumFramework
Selenium Framework project using Java , Maven , TestNG, POM and Docker

Using DDT framework in the project

In addition to Cross-browser testing and using Docker
The setup uses docker-compose to start a selenium hub with three browser nodes.
A simple "docker-compose up" command will set up the environment.

To run the test use your IDE or from the terminal/CMD.

To view reports, run from target folder then surefire-reports then index.html
OR using Allure Reports: run the tests then use this command:
allure.bat serve allure-results

# Tech Stack:

- Java 
- Maven 
- TestNG
- Allure Reports
- Docker
- Data-Driven Testing (DDT)