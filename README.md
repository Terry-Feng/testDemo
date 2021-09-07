# Description of the test project
This project is based on serenity BDD, cucumber and rest-assured, to do the UI and API test together in this project.  
### Getting started
- Install the JDK above version 1.8.0
- Install the Maven, better using the latest version https://maven.apache.org/download.cgi 
- Config environment variables for JAVA and Maven
- Setting up the project
```
git clone https://github.com/Terry-Feng/testDemo.git
```
```
cd testDemo
```
```
mvn clean install
```

### Running Commands

- Run all test 
```
mvn clean verify
```
- Run by tags
```
// run API test
mvn clean verify -Dtags="API"
// run UI test
mvn clean verify -Dtags="UI"
```

### Documentation
https://serenity-bdd.github.io/theserenitybook/latest/index.html 


#### Report
- After test complete, open the file 
```
target/site/serenity/index.html
```
with browser to check the test details.
