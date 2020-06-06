#!/bin/sh

#mkdir target
## shellcheck disable=SC2164
#cd target
#mkdir github-pages
git clone --single-branch --branch gh-pages https://kamil-nowocin:$GITHUBTOKEN@github.com/kamil-nowocin/Test_Automation-automationpractice target/github-pages
sleep 5
cp -R target/github-pages/history build/allure-results
# shellcheck disable=SC2164
cd build
allure generate --clean
sleep 10
cd ..
cp -R build/allure-report/* target/github-pages/
# shellcheck disable=SC2164
cd target/github-pages/
git config user.name "Travis CI"
git config user.email "deploy@travis-ci.org"
git add -A
git commit -m "Auto deploy from Travis CI $TRAVIS_BUILD_NUMBER"
git push origin gh-pages