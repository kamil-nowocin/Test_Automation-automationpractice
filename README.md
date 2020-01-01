![Imgur](https://imgur.com/SeGMpNV.png)
![](https://img.shields.io/badge/language-java-critical)
![](https://img.shields.io/badge/Allure%20Report-2.8.1-orange.svg)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Build Status](https://travis-ci.com/kamil-nowocin/Test_Automation-automationpractice.svg?branch=master)](https://travis-ci.com/kamil-nowocin/Test_Automation-automationpractice)
![GitHub last commit](https://img.shields.io/github/last-commit/kamil-nowocin/Test_Automation-automationpractice)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/kamil-nowocin/Test_Automation-automationpractice)
![GitHub commit activity](https://img.shields.io/github/commit-activity/m/kamil-nowocin/Test_Automation-automationpractice)
# Test automation - http://automationpractice.com
**Design Pattern:** Page Object Model & AAA    
**Following tools were used in this framework:**  
Java, TestNG, Selenium, Gradle, Cucumber, WebDriverManager, Faker & MockNeat, Travis CI, BrowserStack, Allure Reports, GitHub Pages  
## ABOUT PROJECT
Project made in my spare time to develop my skills in automation testing.  
You don't have to download any WebDrivers - I'm using WebDriverManager, drivers will be downloaded by gradle.  
Supported browsers aka hosts:  
* Chrome
* Firefox
* Opera
* Safari
* Edge
## TEST REPORTS
After each build tests results are automatically generated to [kamil-nowocin.github.io](https://kamil-nowocin.github.io/Test_Automation-automationpractice/)
## HOW TO RUN
There are multiple ways to run tests from this build. It all depends on what you want to do.
1. Right click on `.feature` file, and Run -> This will run `.feature` file on default settings.
2. Right click on `TestNGRunner` file, and Run -> This will run all `.feature` files on default settings.
3. In terminal type `./gradlew runTests {run with tags TBA}` -> This will run all `.feature` files which provided tag.
4. In terminal type `./gradlew test` -> This will run all tests from tests package.`(src/test/java/tests)`  
You can add some environment settings, before you run tests with this command, e.g.
   - `-Dselenium.host="YOUR_HOST_NAME"` -> available hosts: Chrome, Firefox, Opera, Safari, Edge, Browserstack
   - `-Dbrowser="YOUR_BROWSER_NAME"` -> available browsers: Chrome, Firefox, IE
5. Create your own runner :hammer_and_wrench:
## Author
**Kamil Nowocin** - *Initial work* - [Kamil Nowocin](https://github.com/kamil-nowocin)
## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details