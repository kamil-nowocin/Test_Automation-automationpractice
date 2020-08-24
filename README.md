![IMG](https://raw.githubusercontent.com/kamil-nowocin/Test_Automation-automationpractice/master/src/test/resources/files/images/readme_banner.jpg)
![JAVA](https://img.shields.io/badge/language-java-critical?style=flat-square)
![ALLURE](https://img.shields.io/badge/Allure%20Report-2.8.1-orange.svg?style=flat-square)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square)](https://opensource.org/licenses/MIT)
[![Build Status](https://img.shields.io/travis/kamil-nowocin/Test_Automation-automationpractice/master.svg?style=flat-square)](https://travis-ci.com/kamil-nowocin/Test_Automation-automationpractice)
![GitHub last commit](https://img.shields.io/github/last-commit/kamil-nowocin/Test_Automation-automationpractice?style=flat-square)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/kamil-nowocin/Test_Automation-automationpractice?style=flat-square)
![GitHub commit activity](https://img.shields.io/github/commit-activity/m/kamil-nowocin/Test_Automation-automationpractice?style=flat-square)
[![LinkedIn](https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555)](https://linkedin.com/in/kamil-nowocin)
# Test automation - http://www.automationpractice.com
**Design Pattern:** Page Object Model with loadable components<sub><sup>(POC)</sub></sup> & AAA  
**Following tools were used in this framework:**  
Java, Selenium, TestNG, Cucumber, REST Assured, Gradle, Travis CI, Allure Reports, Slack API, WebDriverManager, Faker & MockNeat, BrowserStack, GitHub Pages
## ABOUT PROJECT
Project made in my spare time to develop my skills in automation testing.  
You don't have to download any WebDrivers - I'm using WebDriverManager, drivers will be downloaded by gradle.  
Supported browsers aka hosts:
- *Chrome*
- *Firefox*
- *Opera*
- *Safari*
- *Internet Explorer*
- *BrowserStack*
## FEATURES
- Support for Allure Report
- Support for Slack Bot
- Support for Parallel Testing
- Support for BrowserStack
- Support for WebDriverManager
- Support for Fake & Mock data
- Support for .xlsx files
## HOW TO RUN TESTS
There are multiple ways to run tests from this build. It all depends on what you want to do:
1. Right click on `.feature` file, and Run -> This will run `.feature` file on default settings.
2. Right click on `TestNGRunner` file, and Run -> This will run all `.feature` files on default settings.
   - <sub><sup>***This is highly unrecommended option since it's an experimental file and doesn't work well, check build.gradle for more information.***</sup></sub>
3. Right click on `TestNG.xml` file, and Run ->  This will run all test attached to specific runner.
4. In terminal type `./gradlew runTests` -> This will run all `.feature` files.
5. In terminal type `./gradlew runTests {run with tags TBA}` -> This will run all `.feature` files which provided tag.
6. In terminal type `./gradlew test` -> This will run all tests from tests package.`(src/test/java/tests)`  
You can add some environment settings, before you run tests, e.g.
   - `-Dtests.executor="YOUR_HOST_NAME"` -> available hosts: Chrome, Firefox, Opera, Safari, Edge, IE, Safari, BrowserStack
7. Create your own runner :hammer_and_wrench:
## TEST RESULTS (Allure Report)
After each CI/CD cycle run, tests results will be automatically uploaded to [kamil_nowocin.github.io/Test_Automation](https://kamil-nowocin.github.io/Test_Automation-automationpractice/)  
After each LOCAL cycle run, tests results will be stored in build/allure-report.  
In terminal type `allure generate build/allure-report --clean` to generate local Allure Test Results.   

![Imgur](https://raw.githubusercontent.com/kamil-nowocin/Test_Automation-automationpractice/master/src/test/resources/files/images/allure_gif.gif)
## SLACK BOT (Logger)
During CI/CD cycle run, you can see real time test results of TestNG suite execution on [Slack workspace](https://testautomation-travis.slack.com). 

| FAIL MESSAGE  | PASS MESSAGE  |
| ------------- | ------------- |
| ![IMG](https://raw.githubusercontent.com/kamil-nowocin/Test_Automation-automationpractice/master/src/test/resources/files/images/slack_bot_fail.png)  | ![IMG](https://raw.githubusercontent.com/kamil-nowocin/Test_Automation-automationpractice/master/src/test/resources/files/images/slack_bot_pass.png)  |
## TEST LOGS
There are two types of log information saved after each test run:  
- Detailed logs in log directory. Warning! These logs will be deleted when you launch new test run.  
- Colorful logs in testdata.xls file. Warning! These logs will be overwritten when you launch new test run. <sub><sup>(Only for TestNG runners)</sup></sub>
## AUTHORS
- **Kamil Nowocin** - *Initial work* - [Kamil Nowocin](https://github.com/kamil-nowocin)
## LICENSE
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
