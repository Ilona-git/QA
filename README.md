# QA

I create this test with Selenium Webdriver and Java language with TestNG library.

I used Page Object Model along with Page Factory these are design patterns.  The advantage of the POM model is that it reduces code duplication and improves test maintenance.

Base: Under this, I put those codes that need to be called again and again in our test cases like Browser launch.
Pages: Under this, classes are created for each page in the web application and can add more page classes based on the number of pages in the application.
Test cases: Under this, I write the login test cases.
All Dependencies located in the POM.xml file

