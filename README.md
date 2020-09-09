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
Java, Selenium, TestNG, Cucumber, REST Assured, Gradle, Travis CI, Allure Reports, Slack API, SeleniumGrid, WebDriverManager, Faker & MockNeat, BrowserStack, GitHub Pages
  * [About project](#about-project)
  * [Features](#features)
  * [How to run tests](#how-to-run-tests)
    + [TestNG](#testng)
    + [Cucumber](#cucumber)
  * [Test results & Test logs](#test-results--test-logs)
    + [CI/CD](#cicd)
    + [Localhost](#localhost)
    + [TestNG & Cucumber](#testng--cucumber)
  * [Logger (Slack Bot)](#logger-slack-bot)
    + [CI/CD](#cicd-1)
    + [Localhost](#localhost-1)
  * [SeleniumGrid](#selenium-grid-poc)
    + [CI/CD](#cicd-2)
    + [Localhost](#localhost-2)
    + [How to run tests](#how-to-run-tests-1)
  * [Authors](#authors)
  * [License](#license)
## ABOUT PROJECT
Project made in my spare time to develop my skills in automation testing.  
You don't have to download any WebDrivers - I'm using WebDriverManager, drivers will be downloaded by gradle.  
Supported tests executors:
- *Chrome*
- *Firefox*
- *Opera*
- *Safari*
- *Edge*
- *Internet Explorer*
- *SeleniumGrid*
- *BrowserStack*
## FEATURES
- Support for Allure Report
- Support for Slack Bot
- Support for SeleniumGrid
- Support for Parallel Testing
- Support for BrowserStack
- Support for WebDriverManager
- Support for Fake & Mock data
- Support for .xlsx files
## HOW TO RUN TESTS
There are multiple ways to run tests from this build. It all depends on what do you want to do:
### TestNG
- Right click on `TestNG.xml` file, and Run ->  This will run all tests attached to specific xml runner
- In terminal type `./gradlew test` -> This will run all tests from tests package.`(src/test/java/tests)`  
You can add some environment settings, before you run tests, e.g:
   - `-Dtests.executor="YOUR_HOST_NAME"` -> available hosts: Chrome, Firefox, Opera, Safari, Edge, IE, Safari, GRID, BrowserStack   
  <sub>_**This is the best option to run tests, all tools, features are working well while running tests via this commend**_</sub>
### Cucumber
- Right click on `.feature` file, and Run -> This will run `.feature` file on default settings
- In terminal type `./gradlew cucumber` -> This will run all `.feature` files on default settings  
You can add some environment settings, before you run tests, e.g:
   - `-Dtests.executor="YOUR_HOST_NAME"` -> available hosts: Chrome, Firefox, Opera, Safari, Edge, IE, Safari, GRID, BrowserStack
- In terminal type `./gradlew cucumber -Dcucumber.filter.tags="@YOUR_TAG"` -> This will run all `.feature` scenarios which provided tag
- Right click on `CucumberRunner` file, and Run -> This will run all `.feature` files on default settings
  - <sub><sup>*This is highly unrecommended option since it's an experimental file and doesn't work well, check build.gradle for more information*</sup></sub>
- Create your own runner :hammer_and_wrench:
## TEST RESULTS & TEST LOGS
### CI/CD
After each CI/CD cycle run, tests results will be automatically uploaded to [kamil_nowocin.github.io/Test_Automation](https://kamil-nowocin.github.io/Test_Automation-automationpractice/)
### Localhost
After each LOCAL cycle run two types of log information are saved inside repository, together with tests results
### TestNG & Cucumber
- Detailed logs in logs directory
- Colorful logs in testdata.xlsx file
- Allure HTML report in build/allure-results directory

In terminal type `allure generate build/allure-results --clean` to generate Allure tests results   
<sub><sup>*Allure tests results available for running tests via: CucumberRunner, `./gradlew test` or TestMethod with annotation @Test (src/test/java/tests)*</sup></sub>
![Imgur](https://raw.githubusercontent.com/kamil-nowocin/Test_Automation-automationpractice/master/src/test/resources/files/images/allure_gif.gif)
## LOGGER (Slack Bot)
### CI/CD
You are able to see real time summary of TestNG suite execution on [Slack workspace](https://testautomation-travis.slack.com)
### Localhost
Not available

| FAIL MESSAGE  | PASS MESSAGE  |
| ------------- | ------------- |
| ![IMG](https://raw.githubusercontent.com/kamil-nowocin/Test_Automation-automationpractice/master/src/test/resources/files/images/slack_bot_fail.png)  | ![IMG](https://raw.githubusercontent.com/kamil-nowocin/Test_Automation-automationpractice/master/src/test/resources/files/images/slack_bot_pass.png)  |
## SELENIUM GRID (POC)
### CI/CD
Not available
### Localhost
Right now it's only available for a local host, and **it's POC feature**, however you are able to check how it works
### HOW TO RUN TESTS
1. Run SeleniumGridRunner
2. Make sure that SeleniumGrid is running properly, check http://localhost:4444/grid/console
3. In terminal type `./gradlew test -Dtests.executor=grid -Dremote.browser="YOUR_REMOTE_BROWSER"`
## AUTHORS
- **Kamil Nowocin** - *Initial work* - [Kamil Nowocin](https://github.com/kamil-nowocin)
## LICENSE
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
