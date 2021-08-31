# Java-SeleniumCucumber-Project

## Introduction
This automated is written in Java using the Selenium WebDriver and 
Cucumber library. The GoogleTrendsTest feature file contains the scenario
that describes the steps and assertions done during the test. 

The LandingPageSteps class contains the steps found in the feature file together
with the methods that do the actions/assertions. 

The LandingPage class contains element locators and methods that do actions
or return variables that are used in the steps class. 

The RunnerTest and the Hooks classes are helper classes which help instantiate
the WebDriver before a test etc. 

The DriverUtil class is a utility class that contains methods relevant to the
WebDriver configuration. 

## Getting Started

To run this project, you need to run the following commands. 

1. ``mvn clean install -DskipTest=true`` to make sure that all dependencies are downloaded.
2. ``mvn test`` to run the test.

*The test can be run via the IDE too, by clicking the play button next to the Scenario
in the feature file.*