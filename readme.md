**Running Tests**

Precondition : Java 11 or higher and Maven installed and path set

1. Move to the project folder and execute `mvn clean test -Pall`
2. User can run the testng.xml as well after import to favourite IDE. 
Caution : Never run test from inside test class -> Might get NullPointerException because the listeners are configured in testng.xml

**Libraries Used**

1. Rest Assured
2. TestNG
3. AssertJ for Fluent Assertions
4. Json Schema Validator to validate schema
5. Lombok to remove the boiler plate codes.
6. Extent Reports

**Reports**

1. Reports will be automatically generated inside ExtentReports folder.



# RestAssuredAssignment
