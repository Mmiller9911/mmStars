Instructions:

The tests are cucumber based and use a junit runner class to execute.

Pre-requisites:
git
maven
eclipse (or equivalent IDE)
API is running

1.  Clone the repo using - git clone "https://github.com/Mmiller9911/mmStars.git"
2.  Inside the repo open the stars directory and run "maven clean install" (this should download the dependencies)
3.  Open eclipse and import the project as a maven project
4.  Right-click on the file "MainRunner.java" and select "Run As > Junit test"
5.  The tests should run in the eclipse console and also output a report to : Stars\stars\target\cucumber\index.html