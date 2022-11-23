# Brady Coding Test

**Important Note Before Execution** :- Please change the WORKSAPCE_PATH as per your machine location. you can find this in  src/main/java/Utilities/TestUtils.java  

This is one time process and is must for successfull execution of scripts. 
Also please make sure your chromedriver is upto date while running scripts .Otherwise you need to update the chromedriver and then rerun the test cases.


**Project Execution steps:-**

1. Go to the login.feature src/test/resources/Features/login.feature  and press the run button on the left side of scenarios
2. Another way, go to TestRunners src/test/java/runners/TestRunners.java  file and click on run button
3. lastly , you can run via maven too by executing the mvn test command


**POM**

Pages package is maintaining  the objects of home and login pages

**Additional point** 

1. Verification of the login page is done on the basic of userID.
2. Config property file contain the url of application and the browser informatiom
3. Base tests like browser and wait condition are written in base package
4. commonly used functions are in Utilites package
5. last exachnge rate and last three exchange rate are output in ExchangeRates.properties file under taget folder. so once you exxecute the case , you cann see the results there.
6. Tool used in intellij with maven and java
7. Code is reuseable and not only GBPJPY rates you can see but other rates also you can verify with same code .just pass the right code in feature file.

**Additional Tests**
1. We cound have include negative test cases too. 
2. login with incorrect credentials
3. find the exchange rate of wrong currency
4. validate different error message that appears
