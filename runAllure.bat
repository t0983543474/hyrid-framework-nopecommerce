set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath% 
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.8.10.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libAllure\*;%ProjectPath%libExtentV5\*;%ProjectPath%librariesLog4j\*;%ProjectPath%libraries\*;%ProjectPath%libReportNg\*;%ProjectPath%librariesDriver\*" org.testng.TestNG "%ProjectPath%bin\runNopEcommerceUserTest.xml"
pause