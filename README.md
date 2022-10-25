# efinancialcareer
**Project Execution steps:-**

1. Go to the login.feature src/test/resources/Features/login.feature  and press the run button on the left side of scenarios
2. Another way, go to TestRunners src/test/java/runners/TestRunners.java  file and click on run button
3. lastly , you can run via maven too by executing the mvn test command

**Important Note Before Execution** :- Please change the WORKSAPCE_PATH as per your machine in location src/main/java/Utilities/TestUtils.java


**POM**

Pages package is maintaining  the objects of home and login pages

**Additional point** 

1. Verification of the login page is done on the basic of email ID.
2. Config property file contain the url of application and the browser informatiom
3. Base tests like browser and wait condition are written in base package
4. commonly used functions are in Utilites package