![Imgur](https://imgur.com/SeGMpNV.png)
![](https://img.shields.io/badge/language-java-critical)
![](https://img.shields.io/badge/Allure%20Report-2.8.1-orange.svg)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Build Status](https://travis-ci.com/kamil-nowocin/Test_Automation-automationpractice.svg?branch=master)](https://travis-ci.com/kamil-nowocin/Test_Automation-automationpractice)
![GitHub last commit](https://img.shields.io/github/last-commit/kamil-nowocin/Test_Automation-automationpractice)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/kamil-nowocin/Test_Automation-automationpractice)
![GitHub commit activity](https://img.shields.io/github/commit-activity/m/kamil-nowocin/Test_Automation-automationpractice)
# Test automation - http://www.automationpractice.com
**Design Pattern:** Page Object Model & AAA  
**Following tools were used in this framework:**  
Java, TestNG, REST Assured, Selenium, Gradle, Cucumber, WebDriverManager, Faker & MockNeat, Travis CI, BrowserStack, Allure Reports, GitHub Pages
## ABOUT PROJECT
Project made in my spare time to develop my skills in automation testing.  
You don't have to download any WebDrivers - I'm using WebDriverManager, drivers will be downloaded by gradle.  
Supported browsers aka hosts:  
* *Chrome*
* *Firefox*
* *Opera*
* *Safari*
* *Edge*
## TEST REPORTS & LOGS
After each CI/CD test run, tests results are automatically transfered to [kamil-nowocin.github.io](https://kamil-nowocin.github.io/Test_Automation-automationpractice/)  
Local test results are stored in build/allure-report. In terminal type `allure-generate build/allure-report --clean`  
Local logs are stored separately, for each tests case. Logs will be deleted when you launch new test run.
## HOW TO RUN
There are multiple ways to run tests from this build. It all depends on what you want to do:
1. Right click on `.feature` file, and Run -> This will run `.feature` file on default settings.
2. Right click on `TestNGRunner` file, and Run -> This will run all `.feature` files on default settings.
   - <sub><sup>***This is highly unrecommended option since it's experimental file and doesn't work well, check build.gradle for more information.***</sup></sub>
3. Right click on `TestNG.xml` file, and Run ->  This will run all test attached to specific runner.
     - <sub><sup>***This is highly recommended option for launching tests.***</sup></sub>
4. In terminal type `./gradlew runTests` -> This will run all `.feature` files.
5. In terminal type `./gradlew runTests {run with tags TBA}` -> This will run all `.feature` files which provided tag.
6. In terminal type `./gradlew test` -> This will run all tests from tests package.`(src/test/java/tests)`  
You can add some environment settings, before you run tests with this command, e.g.
   - `-Dselenium.host="YOUR_HOST_NAME"` -> available hosts: Chrome, Firefox, Opera, Safari, Edge, Browserstack
   - `-Dbrowser="YOUR_BROWSER_NAME"` -> available browsers: Chrome, Firefox, IE
7. Create your own runner :hammer_and_wrench:
## AUTHORS
- **Kamil Nowocin** - *Initial work* - [Kamil Nowocin](https://github.com/kamil-nowocin)
## LICENSE
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
## TODO LIST
- [ ] More REST tests -> if possible
- [ ] Something with docker
- [ ] Video recorder for failed tests 