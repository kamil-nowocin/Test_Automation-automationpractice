#!/bin/sh

git clone --single-branch --branch gh-pages https://kamil-nowocin:$GITHUB_TOKEN@github.com/kamil-nowocin/Test_Automation-automationpractice target/github-pages
sleep 5
cp -R target/github-pages/history build/allure-results
cd build
allure generate --clean
sleep 10
cd ..
cp -R build/allure-report/* target/github-pages/
cd target/github-pages/
git config user.name "Travis CI"
git config user.email "deploy@travis-ci.org"
git add -A
git commit -m "Auto deploy from Travis CI $TRAVIS_BUILD_NUMBER"
git push origin gh-pages