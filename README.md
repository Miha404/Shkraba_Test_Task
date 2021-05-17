## How to run:
Run command in terminal:

> mvn clean install -Dmaven.test.skip=true

> mvn clean test  
> (the URL of the page is contained in the config.properties)


Command for report:

>mvn allure:serve

or in the terminal go to the target folder and run generate a report:

> allure generate

after generation, you can open report:
> allure open

## Dependencies:
- Java (15.0.2 version)
- Maven (3.6.3 version)
- Selenide (5.20.4 version)
- TestNG (7.1.0 version) 
- Lombok (1.18.16 version)
- log4j (1.2.17 version)
- Allure (2.13.6 version)
- WebDriverManager (4.4.1 version)

